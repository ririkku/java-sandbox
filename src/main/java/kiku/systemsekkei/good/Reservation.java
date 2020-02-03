package kiku.systemsekkei.good;

import kiku.systemsekkei.Yen;

import java.util.List;

public class Reservation {

    List<Fee> fees;

    public Reservation(List<Fee> fees) {
        this.fees = fees;
    }

    void addFee(Fee fee) {
        fees.add(fee);
    }

    Yen feeTotal() {
        return new Yen(fees.stream()
                .mapToInt(fee -> fee.yen().value())
                .sum());
    }
}
