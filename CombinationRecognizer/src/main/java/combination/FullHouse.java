package combination;

import units.Card;

import java.util.List;

public class FullHouse extends Combination {

    protected final Integer POWER = 7;

    public FullHouse(List<Card> cards) {
        super(cards);
    }

    @Override
    protected Card determineSideCard() {
        if (CARDS.get(0).compareTo(CARDS.get(2)) == 0) {
            return CARDS.get(3);
        } else {
            return CARDS.get(0);
        }
    }

    @Override
    protected Card determineHighCard() {
        return CARDS.get(2);
    }

    @Override
    protected int compareWithSameCombination(Combination combination) {
        FullHouse fullHouse = (FullHouse) combination;
        if (this.HIGH_CARD.compareTo(fullHouse.HIGH_CARD) == 0) {
            return this.SIDE_CARD.compareTo(fullHouse.SIDE_CARD);
        } else {
            return this.HIGH_CARD.compareTo(fullHouse.HIGH_CARD);
        }
    }
}
