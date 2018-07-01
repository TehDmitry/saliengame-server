package ru.tehdmitry.apiObjects;

public class BossPlayer {
    public int accountid = 9310;
    public Salien salien = new Salien();

    public int hp = 99;
    //public int hp = 0;
    public int max_hp = 100;
    public String name = "Illusion";



    public BossPlayer(int accountid) {
        this.accountid = accountid;
    }
}
