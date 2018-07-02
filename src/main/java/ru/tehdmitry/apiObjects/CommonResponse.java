package ru.tehdmitry.apiObjects;

import java.util.ArrayList;
import java.util.List;

public class CommonResponse {
    public List<Planet> planets = new ArrayList<Planet>();
    public boolean game_over = false;
    //public boolean game_over = true;
    public int num_laser_uses = 99;
    public Boolean waiting_for_players = false;

    public BossDamage bossDamage;
    public BossStatus boss_status;
    public int game_version = 2;

    public void setBossDamage(BossDamage bossDamage) {
        this.bossDamage = bossDamage;
    }

    public void setBossStatus(BossStatus bossStatus) {
        this.boss_status = bossStatus;
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }
}
