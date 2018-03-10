package combination;

import comparators.ValueComparator;
import units.Card;

import java.util.HashSet;
import java.util.List;

public class FourOfKind extends Combination {
    protected final Integer POWER = 8;

    public FourOfKind(List<Card> cards) {
        super(cards);
    }

    @Override
    protected Card determineSideCard() {
        if (CARDS.get(0).compareTo(CARDS.get(1)) == 0) {
            return CARDS.get(4);
        } else {
            return CARDS.get(0);
        }
    }

    @Override
    protected Card determineHighCard() {
        if (CARDS.get(0).compareTo(CARDS.get(1)) == 0) {
            return CARDS.get(0);
        } else {
            return CARDS.get(0);
        }
    }

    @Override
    protected int compareWithSameCombination(Combination combination) {
        FourOfKind fourOfKind = (FourOfKind) combination;
        if (this.HIGH_CARD.compareTo(fourOfKind.HIGH_CARD) == 0) {
            return this.SIDE_CARD.compareTo(fourOfKind.SIDE_CARD);
        } else {
            return this.HIGH_CARD.compareTo(fourOfKind.HIGH_CARD);
        }
    }
}
