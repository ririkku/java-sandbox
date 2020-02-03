package kiku.systemsekkei.good;

import kiku.systemsekkei.Yen;

public class SeniorFee implements Fee {

    @Override
    public Yen yen() {
        return new Yen(80);
    }

    @Override
    public String label() {
        return "シニア";
    }
}
