package comparators;

import units.Card;

import java.util.Comparator;

public class MastComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        if (o1.getMAST().getValue() > o2.getMAST().getValue()) {
            return 1;
        } else if (o1.getMAST().getValue() < o2.getMAST().getValue()) {
            return -1;
        } else {
            return 0;
        }
    }
}
