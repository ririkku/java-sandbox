package kiku.systemsekkei.good;

import kiku.systemsekkei.Yen;

public class Charge {

    private Fee fee;

    public Charge(Fee fee) {
        this.fee = fee;
    }

    public Yen yen() {
        return fee.yen();
    }
}
