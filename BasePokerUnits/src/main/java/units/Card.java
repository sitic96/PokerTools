package units;

import enums.Mast;

/**
 * Каждая игральная карта имеет три основных параметра:
 * VALUE - сила карты, может быть от 2 до 14 (Туз)
 * NAME - буквенная интерпретация VALUE, 2 - 2, 14 - A (туз), 12 - Q (дама)
 * MAST - масть карты (например, буба)
 */

public class Card implements Comparable<Card> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        return VALUE == card.VALUE && MAST == card.MAST;
    }

    @Override
    public int hashCode() {
        int result = VALUE;
        result = 31 * result + MAST.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "" + NAME + MAST.toString().charAt(0);
    }

    @Override
    public int compareTo(Card o) {
        if (this.VALUE > o.VALUE) {
            return 1;
        } else if (this.VALUE < o.VALUE) {
            return -1;
        } else {
            return 0;
        }
    }
}
