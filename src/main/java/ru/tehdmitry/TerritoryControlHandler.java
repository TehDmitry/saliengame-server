package ru.tehdmitry;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.FileUtils;
import io.undertow.util.Headers;
import io.undertow.util.HttpString;
import org.codehaus.jackson.map.ObjectMapper;
import ru.tehdmitry.apiObjects.ApiResponse;
import ru.tehdmitry.apiObjects.BossDamage;
import ru.tehdmitry.apiObjects.BossStatus;
import ru.tehdmitry.apiObjects.Planet;

public class TerritoryControlHandler implements HttpHandler {
    ObjectMapper mapper = new ObjectMapper();

    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
        exchange.getResponseHeaders().put(new HttpString("x-eresult"), 1);

        exchange.getPathParameters();

        ApiResponse apiResponse = new ApiResponse();

        if (exchange.getRelativePath().equals("/GetPlayerInfo/v0001/")) {
            //exchange.getResponseSender().send("{\"response\":{\"active_planet\":\"17\",\"time_on_planet\":575,\"score\":\"2169535\",\"level\":10,\"next_level_score\":\"2400000\"}}");
            exchange.getResponseSender().send("{\"response\":{\"score\":\"2169535\",\"level\":10,\"next_level_score\":\"2400000\"}}");
        }

        if (exchange.getRelativePath().contains("/GetPlanet/v0001/")) {
            apiResponse.response.addPlanet(new Planet("17", true, 0));
            String jsonInString = mapper.writeValueAsString(apiResponse);
            exchange.getResponseSender().send(jsonInString);
        }
        if (exchange.getRelativePath().equals("/JoinZone/v0001/")) {
            exchange.getResponseSender().send("{\"response\":{\"zone_info\":{\"zone_position\":61,\"leader\":{\"accountid\":4777282,\"name\":\"SteaмDB\",\"avatar\":\"ecf2f471610eb2c59253359fa2b7ec944fedd076\",\"url\":\"SteamDB\"},\"type\":3,\"gameid\":\"1209\",\"difficulty\":2,\"captured\":false,\"capture_progress\":0.133549317717552185,\"top_clans\":[{\"accountid\":4777282,\"name\":\"SteaмDB\",\"avatar\":\"ecf2f471610eb2c59253359fa2b7ec944fedd076\",\"url\":\"SteamDB\"},{\"accountid\":5151157,\"name\":\"Steam Universe\",\"avatar\":\"e34e65ef2ef16093d4428c930fbcc42490522ed3\",\"url\":\"steamuniverse\"},{\"accountid\":255962,\"name\":\"STCN\",\"avatar\":\"f2a29784032f714eb79afbd2c94767d17101f871\",\"url\":\"SteamCN\"},{\"accountid\":275018,\"name\":\"Reddit\",\"avatar\":\"d5a5703f389be71faddc08253bc492187383b172\",\"url\":\"reddit\"},{\"accountid\":148845,\"name\":\"Hentai!\",\"avatar\":\"4ff6a96268bb05113b88faf1c9688301e8cfa706\",\"url\":\"hentaii\"}]}}}");
        }
        if (exchange.getRelativePath().equals("/ReportScore/v0001/")) {
            exchange.getResponseSender().send("{\"response\":{\"old_score\":\"2169535\",\"old_level\":10,\"new_score\":\"2170595\",\"new_level\":10,\"next_level_score\":\"2400000\"}}");
        }

        if (exchange.getRelativePath().equals("/JoinBossZone/v0001/")) {
            exchange.getResponseSender().send("{\"response\":{\"zone_info\":{\"zone_position\":61,\"leader\":{\"accountid\":4777282,\"name\":\"SteaмDB\",\"avatar\":\"ecf2f471610eb2c59253359fa2b7ec944fedd076\",\"url\":\"SteamDB\"},\"type\":3,\"gameid\":\"1209\",\"difficulty\":2,\"captured\":false,\"capture_progress\":0.133549317717552185,\"top_clans\":[{\"accountid\":4777282,\"name\":\"SteaмDB\",\"avatar\":\"ecf2f471610eb2c59253359fa2b7ec944fedd076\",\"url\":\"SteamDB\"},{\"accountid\":5151157,\"name\":\"Steam Universe\",\"avatar\":\"e34e65ef2ef16093d4428c930fbcc42490522ed3\",\"url\":\"steamuniverse\"},{\"accountid\":255962,\"name\":\"STCN\",\"avatar\":\"f2a29784032f714eb79afbd2c94767d17101f871\",\"url\":\"SteamCN\"},{\"accountid\":275018,\"name\":\"Reddit\",\"avatar\":\"d5a5703f389be71faddc08253bc492187383b172\",\"url\":\"reddit\"},{\"accountid\":148845,\"name\":\"Hentai!\",\"avatar\":\"4ff6a96268bb05113b88faf1c9688301e8cfa706\",\"url\":\"hentaii\"}]}}}");
        }

        if (exchange.getRelativePath().equals("/ReportBossDamage/v0001/")) {
            BossDamage bossDamage = new BossDamage();
            BossStatus bossStatus = new BossStatus();


            apiResponse.response.setBossDamage(bossDamage);
            apiResponse.response.setBossStatus(bossStatus);

            String jsonInString = mapper.writeValueAsString(apiResponse);
            exchange.getResponseSender().send(jsonInString);
            //exchange.getResponseSender().send("{\"response\":{}}");
        }

        if (exchange.getRelativePath().equals("/LeaveGame/v0001/")) {
            exchange.getResponseSender().send("{\"response\":{}}");
        }

        if (exchange.getRelativePath().equals("/GetPlanets/v0001/")) {
            apiResponse.response.addPlanet(new Planet("17", false, 0));
            apiResponse.response.addPlanet(new Planet("18", false, 1));
            apiResponse.response.addPlanet(new Planet("19", false,2));
            apiResponse.response.addPlanet(new Planet("20", false, 3));
            String jsonInString = mapper.writeValueAsString(apiResponse);
            exchange.getResponseSender().send(jsonInString);
        }

        if (exchange.getRelativePath().equals("/JoinPlanet/v0001/")) {
            exchange.getResponseSender().send("{\"response\":{}}");
        }
    }
}
