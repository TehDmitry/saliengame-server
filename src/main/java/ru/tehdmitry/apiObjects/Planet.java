package ru.tehdmitry.apiObjects;

import java.util.ArrayList;
import java.util.List;

public class Planet {
    public String id;
    public PlanetState state;
    public List<Integer> giveaway_apps = new ArrayList<Integer>();
    public List<PlanetTopClan> top_clans = new ArrayList<PlanetTopClan>();
    public List<PlanetZone> zones = new ArrayList<PlanetZone>();


    public Planet(String id) {
        this.id = id;

        for (int i = 0; i <= 95; i++) {
            zones.add(new PlanetZone(i, 3, 4));
        }

        state = new PlanetState();
    }
}
