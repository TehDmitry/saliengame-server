package ru.tehdmitry;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import io.undertow.util.HttpString;
import org.codehaus.jackson.map.ObjectMapper;
import ru.tehdmitry.apiObjects.ApiResponse;

public class MiniGameHandler implements HttpHandler {
    ObjectMapper mapper = new ObjectMapper();

    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
        exchange.getResponseHeaders().put(new HttpString("x-eresult"), 1);

        exchange.getPathParameters();

        ApiResponse apiResponse = new ApiResponse();

        if (exchange.getRelativePath().equals("/LeaveGame/v0001/")) {
            String jsonInString = mapper.writeValueAsString(apiResponse);
            exchange.getResponseSender().send(jsonInString);
            //exchange.getResponseSender().send("{\"response\":{}}");
        }
    }
}
