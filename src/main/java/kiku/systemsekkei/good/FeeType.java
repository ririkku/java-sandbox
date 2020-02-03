package kiku.systemsekkei.good;

public enum FeeType {
    adult(new AdultFee()),
    child(new ChildFee()),
    senior(new SeniorFee());

    private Fee fee;

    FeeType(Fee fee) {
        this.fee = fee;
    }

    public static Fee of(String feeTypeName) {
        FeeType feeType = FeeType.valueOf(feeTypeName);
        return feeType.fee;
    }

    public Fee fee() {
        return fee;
    }

    public static boolean isAdult(String typeName) {
        FeeType feeType = FeeType.valueOf(typeName);
        return FeeType.adult.equals(feeType);
    }

    public static boolean isChild(String typeName) {
        FeeType feeType = FeeType.valueOf(typeName);
        return FeeType.child.equals(feeType);
    }

    public static boolean isSenior(String typeName) {
        FeeType feeType = FeeType.valueOf(typeName);
        return FeeType.senior.equals(feeType);
    }
}
