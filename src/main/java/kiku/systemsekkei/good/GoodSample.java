package kiku.systemsekkei.good;

import kiku.systemsekkei.Yen;

/**
 * 早期Returnとガード節の例
 */
public class GoodSample {

    public static void main(String[] args) {

        // enum良い感じに使うと、こんな書き方ができる
        String typeName = "adult";
        if (FeeType.isAdult(typeName)) {
            Fee adult = FeeType.adult.fee();
            Charge charge = new Charge(adult);
        }
        if (FeeType.isChild(typeName)) {
            Fee child = FeeType.child.fee();
            Charge charge = new Charge(child);
        }
        if (FeeType.isSenior(typeName)) {
            Fee senior = FeeType.senior.fee();
            Charge charge = new Charge(senior);
        }

        // typeNameが存在を確定していて条件分岐しない場合はよりシンプル
        Fee fee = FeeType.of(typeName);
        Charge charge = new Charge(fee);
    }
}
