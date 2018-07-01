package ru.tehdmitry.apiObjects;

public class Salien {
    public int body_type = 3;
    public int mouth = 3;
    public int eyes = 3;
    public int arms = 3;
    public int legs = 3;
    public int hat_itemid = 0;
    public int shirt_itemid = 0;

    public Salien() {
        body_type = randInt(1, 3);
        mouth = randInt(1, 12);
        eyes = randInt(1, 11);
        arms = randInt(1, 9);
        legs = randInt(1, 9);
    }

    private int randInt(int Min, int Max) {
        return  Min + (int)(Math.random() * ((Max - Min) + 1));
    }
}
