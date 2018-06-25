package ru.tehdmitry;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;


public class SaliengameHandler implements HttpHandler {


    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
        exchange.getPathParameters();
        if(exchange.getRelativePath().equals("/gettoken")) {
            exchange.getResponseSender().send("{\"webapi_host\":\"http:\\/\\/localhost:8080\\/\",\"webapi_host_secure\":\"http:\\/\\/localhost:8080\\/\",\"token\":\"token\",\"steamid\":\"steamid\",\"persona_name\":\"persona_name\",\"success\":1}");
        }

    }
}
