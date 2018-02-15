import enums.Mast;

public class Card implements Comparable {
    private final int VALUE;
    private final char NAME;
    private final Mast MAST;

    public Card(int value, Mast mast) {
        this.VALUE = value;
        this.NAME = cardNameByValue(value);
        this.MAST = mast;
    }

    public int getVALUE() {
        return VALUE;
    }

    public char getNAME() {
        return NAME;
    }

    public Mast getMAST() {
        return MAST;
    }

    private char cardNameByValue(int value) {
        switch (value) {
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';
            case 10:
                return 'T';
            case 11:
                return 'J';
            case 12:
                return 'Q';
            case 13:
                return 'K';
            case 14:
                return 'A';
            default:
                throw new ExceptionInInitializerError("Incorrect card value");
        }
    }

    //TODO OVERRIDE
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        return VALUE == card.VALUE && MAST == card.MAST;
    }

    @Override
    public String toString() {
        return "" + NAME + MAST.toString().charAt(0);
    }
}
