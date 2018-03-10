package combination;

import units.Card;

import java.util.HashSet;
import java.util.List;

public class Street extends Combination {

    protected final Integer POWER = 5;

    public Street(List<Card> cards) {
        super(cards);
    }

    @Override
    protected Card determineSideCard() {
        return null;
    }

    @Override
    protected Card determineHighCard() {
        return CARDS.get(4);
    }

    @Override
    protected int compareWithSameCombination(Combination combination) {
        Street street = (Street) combination;
        return this.HIGH_CARD.compareTo(street.HIGH_CARD);
    }
}
