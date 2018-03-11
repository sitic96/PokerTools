package combination;

import units.Card;

import java.util.List;

public class TwoPair extends Combination {

    protected final Integer POWER = 3;
    private Card secondPairCard;

    public TwoPair(List<Card> cards) {
        super(cards);
    }

    @Override
    protected Card determineSideCard() {
        if (CARDS.get(0).compareTo(CARDS.get(1)) == 0 && CARDS.get(3).compareTo(CARDS.get(4)) == 0) {
            secondPairCard = CARDS.get(3);
            return CARDS.get(2);
        } else if (CARDS.get(0).compareTo(CARDS.get(1)) == 0 && CARDS.get(2).compareTo(CARDS.get(3)) == 0) {
            secondPairCard = CARDS.get(2);
            return CARDS.get(4);
        } else {
            secondPairCard = CARDS.get(3);
            return CARDS.get(0);
        }
    }

    @Override
    protected Card determineHighCard() {
        if (CARDS.get(0).compareTo(CARDS.get(1)) == 0) {
            return CARDS.get(0);
        } else {
            return CARDS.get(1);
        }
    }

    @Override
    protected int compareWithSameCombination(Combination combination) {
        TwoPair twoPair = (TwoPair) combination;

        if (this.HIGH_CARD.compareTo(twoPair.HIGH_CARD) == 0) {
            if (this.secondPairCard.compareTo(twoPair.secondPairCard) == 0) {
                return this.SIDE_CARD.compareTo(twoPair.SIDE_CARD);
            } else {
                return this.secondPairCard.compareTo(twoPair.secondPairCard);
            }
        } else {
            return this.HIGH_CARD.compareTo(twoPair.HIGH_CARD);
        }
    }
}
