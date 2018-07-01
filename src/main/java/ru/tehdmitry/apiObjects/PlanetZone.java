package ru.tehdmitry.apiObjects;

import java.util.ArrayList;
import java.util.List;

public class PlanetZone {
    public int zone_position;
    public PlanetZoneTopClan leader = new PlanetZoneTopClan();
    public int type; //3 - common, 4 - boss
    public String gameid = "1526";
    public int difficulty ;
    public Boolean captured = false;
    public Double capture_progress = 0.2; //0.0182790998369455338;
    public List<PlanetZoneTopClan> top_clans = new ArrayList<PlanetZoneTopClan>();
    //public Boolean boss = true;
    public Boolean boss_active = false;

    public PlanetZone(int zone_position, int difficulty, int type) {
        this.zone_position = zone_position;
        this.difficulty = difficulty;
        this.type = type;

        if(type == 4) {
            boss_active = true;
        }
    }
}
