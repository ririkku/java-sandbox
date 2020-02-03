package kiku.systemsekkei.good;

import kiku.systemsekkei.Yen;

public class ChildFee implements Fee {

    @Override
    public Yen yen() {
        return new Yen(50);
    }

    @Override
    public String label() {
        return "子供";
    }
}
