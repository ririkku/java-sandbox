package kiku.generics;

import java.math.BigDecimal;

public class GenericsSample<T> {

    public void method1() {
        String a = staticMethod("A");
        Integer integer = staticMethod(2);

        String a1 = instanceMethod("a");
        BigDecimal bigDecimal = instanceMethod(BigDecimal.ONE);
    }

    static <T> T staticMethod(T obj) {
        return obj;
    }

    <T> T instanceMethod(T obj) {
        return obj;
    }
}
