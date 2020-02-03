package kiku.systemsekkei.bad;

import kiku.systemsekkei.Yen;

/**
 * 早期Returnとガード節の例
 */
public class BadSample {

    public void main() {
        // 別にここだけなら良いが、他の場所で使用する場合はDRYに反すると思う
        Yen fee;
        String label;
        if (isChild("child")) {
            fee = childFee();
            label = "子供";
        } else if (isSenior("senior")) {
            fee = seniorFee();
            label = "シニア";
        } else if (isAdult("adult")) {
            fee = adultFee();
            label = "大人";
        } else {
            fee = new Yen(0);
            label = "";
        }
    }

    private boolean isAdult(String name) {
        return "adult".equals(name);
    }

    private boolean isChild(String name) {
        return "child".equals(name);
    }

    private boolean isSenior(String name) {
        return "senior".equals(name);
    }

    private Yen adultFee() {
        return new Yen(100);
    }

    private Yen childFee() {
        return new Yen(50);
    }

    private Yen seniorFee() {
        return new Yen(80);
    }
}
