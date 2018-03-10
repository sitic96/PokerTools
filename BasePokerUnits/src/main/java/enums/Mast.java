package enums;

public enum Mast {
    HEART(0), DIAMOND(1), CLUB(2), SPADE(3);

    private final int value;
    Mast(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
