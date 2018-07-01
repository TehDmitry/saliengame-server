package ru.tehdmitry;


import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.resource.FileResourceManager;

import java.io.File;

import static io.undertow.Handlers.resource;

public class Webserver {

    public void start() throws Exception {
        Undertow.builder().addHttpListener(8080, "0.0.0.0")
                .setHandler(Handlers.path()
                        .addPrefixPath("/saliengame/", new SaliengameHandler())
                        .addPrefixPath("/ITerritoryControlMinigameService/", new TerritoryControlHandler())
                        .addPrefixPath("/IMiniGameService/", new MiniGameHandler())
                        .addPrefixPath("/", resource(new FileResourceManager(new File("webapp"), 1024)))
                 ).build().start();
    }
}
