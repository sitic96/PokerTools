package combination;

import comparators.ValueComparator;
import units.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Combination implements Comparable<Combination> {
    protected final Integer POWER = -1;
    protected final Card SIDE_CARD;
    protected final Card HIGH_CARD;
    protected final List<Card> CARDS;

    public Combination(List<Card> cards) {
        this.CARDS = new ArrayList<>(cards);
        this.CARDS.sort(new ValueComparator());
        SIDE_CARD = determineSideCard();
        HIGH_CARD = determineHighCard();
    }

    protected abstract Card determineSideCard();

    protected abstract Card determineHighCard();

    public Integer getPOWER() {
        return POWER;
    }

    public List<Card> getCARDS() {
        return CARDS;
    }

    @Override
    public int compareTo(Combination o) {
        if (getClass() == o.getClass()) {
            return this.compareWithSameCombination(o);
        }
        if (this.POWER > o.getPOWER()) {
            return 1;
        } else if (this.POWER < o.getPOWER()) {
            return -1;
        } else {
            return 0;
        }
    }

    protected int compareWithSameCombination(Combination combination) {
        return 0;
    }
}
