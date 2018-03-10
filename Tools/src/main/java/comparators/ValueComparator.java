package comparators;

import units.Card;

import java.util.Comparator;

public class ValueComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        if (o1.getVALUE() > o2.getVALUE()) {
            return 1;
        } else if (o1.getVALUE() < o2.getVALUE()) {
            return -1;
        } else {
            return 0;
        }
    }
}
