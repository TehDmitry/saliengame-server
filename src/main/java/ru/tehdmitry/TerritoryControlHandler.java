package ru.tehdmitry;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.FileUtils;
import io.undertow.util.Headers;
import io.undertow.util.HttpString;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TerritoryControlHandler implements HttpHandler {

    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
        exchange.getResponseHeaders().put(new HttpString("x-eresult"), 1);

        exchange.getPathParameters();
        if (exchange.getRelativePath().equals("/GetPlayerInfo/v0001/")) {
            exchange.getResponseSender().send("{\"response\":{\"active_planet\":\"17\",\"time_on_planet\":575,\"score\":\"2169535\",\"level\":10,\"next_level_score\":\"2400000\"}}");
        }

        if (exchange.getRelativePath().contains("/GetPlanet/v0001/")) {
            byte[] encoded = Files.readAllBytes(Paths.get("src/main/resources/GetPlanet.json"));
            String f = new String(encoded,  StandardCharsets.UTF_8);
            exchange.getResponseSender().send(f);
        }
        if (exchange.getRelativePath().equals("/JoinZone/v0001/")) {
            exchange.getResponseSender().send("{\"response\":{\"zone_info\":{\"zone_position\":61,\"leader\":{\"accountid\":4777282,\"name\":\"SteaмDB\",\"avatar\":\"ecf2f471610eb2c59253359fa2b7ec944fedd076\",\"url\":\"SteamDB\"},\"type\":3,\"gameid\":\"1209\",\"difficulty\":2,\"captured\":false,\"capture_progress\":0.133549317717552185,\"top_clans\":[{\"accountid\":4777282,\"name\":\"SteaмDB\",\"avatar\":\"ecf2f471610eb2c59253359fa2b7ec944fedd076\",\"url\":\"SteamDB\"},{\"accountid\":5151157,\"name\":\"Steam Universe\",\"avatar\":\"e34e65ef2ef16093d4428c930fbcc42490522ed3\",\"url\":\"steamuniverse\"},{\"accountid\":255962,\"name\":\"STCN\",\"avatar\":\"f2a29784032f714eb79afbd2c94767d17101f871\",\"url\":\"SteamCN\"},{\"accountid\":275018,\"name\":\"Reddit\",\"avatar\":\"d5a5703f389be71faddc08253bc492187383b172\",\"url\":\"reddit\"},{\"accountid\":148845,\"name\":\"Hentai!\",\"avatar\":\"4ff6a96268bb05113b88faf1c9688301e8cfa706\",\"url\":\"hentaii\"}]}}}");
        }

    }
}
