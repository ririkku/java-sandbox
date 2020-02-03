package kiku.systemsekkei.good;

import kiku.systemsekkei.Yen;

public class AdultFee implements Fee {

    @Override
    public Yen yen() {
        return new Yen(100);
    }

    @Override
    public String label() {
        return "大人";
    }
}
