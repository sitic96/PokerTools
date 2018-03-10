package combination;

import comparators.ValueComparator;
import units.Card;

import java.util.List;

public class StreetFlash extends Combination {
    protected final Integer POWER = 9;

    public StreetFlash(List<Card> cards) {
        super(cards);
    }

    @Override
    protected Card determineSideCard() {
        return null;
    }

    @Override
    protected Card determineHighCard() {
        return this.CARDS.get(4);
    }

    @Override
    protected int compareWithSameCombination(Combination combination) {
        StreetFlash streetFlash1 = (StreetFlash) combination;

        if (this.HIGH_CARD.getVALUE() > streetFlash1.HIGH_CARD.getVALUE()) {
            return 1;
        } else if (this.HIGH_CARD.getVALUE() < streetFlash1.HIGH_CARD.getVALUE()) {
            return -1;
        } else {
            return 0;
        }
    }
}
