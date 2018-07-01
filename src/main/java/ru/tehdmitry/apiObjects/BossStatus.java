package ru.tehdmitry.apiObjects;

import java.util.ArrayList;
import java.util.List;

public class BossStatus {
    public int boss_hp = 100;
    public int boss_max_hp = 1000;
    public List<BossPlayer> boss_players = new ArrayList<BossPlayer>();

    public BossStatus() {
        boss_players.add(new BossPlayer(9310));
        for (int i = 0; i < 10; i++) {
            boss_players.add(new BossPlayer(9000 + i));
        }
    }
}
