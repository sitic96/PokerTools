package combination;

import units.Card;

import java.util.HashSet;
import java.util.List;

public class Pair extends Combination {

    protected final Integer POWER = 2;

    private Card secondSideCard;
    private Card thirdSideCard;

    public Pair(List<Card> cards) {
        super(cards);
    }

    @Override
    protected Card determineSideCard() {
        if (CARDS.get(0).compareTo(CARDS.get(1)) == 0) {
            secondSideCard = CARDS.get(3);
            thirdSideCard = CARDS.get(4);
            return CARDS.get(2);
        } else {
            if (CARDS.get(1).compareTo(CARDS.get(2)) == 0) {
                secondSideCard = CARDS.get(3);
                thirdSideCard = CARDS.get(4);
            } else if (CARDS.get(2).compareTo(CARDS.get(3)) == 0) {
                secondSideCard = CARDS.get(1);
                thirdSideCard = CARDS.get(4);
            } else {
                secondSideCard = CARDS.get(1);
                thirdSideCard = CARDS.get(2);
            }
            return CARDS.get(0);
        }

    }

    @Override
    protected Card determineHighCard() {
        if (CARDS.get(0).compareTo(CARDS.get(1)) == 0) {
            return CARDS.get(0);
        } else if (CARDS.get(1).compareTo(CARDS.get(2)) == 0) {
            return CARDS.get(1);
        } else if (CARDS.get(2).compareTo(CARDS.get(3)) == 0) {
            return CARDS.get(2);
        } else {
            return CARDS.get(3);
        }
    }

    @Override
    protected int compareWithSameCombination(Combination combination) {
        Pair pair = (Pair) combination;

        if (this.HIGH_CARD.compareTo(pair.HIGH_CARD) != 0) {
            return this.HIGH_CARD.compareTo(pair.HIGH_CARD);
        } else if (this.SIDE_CARD.compareTo(pair.SIDE_CARD) != 0) {
            return this.SIDE_CARD.compareTo(pair.SIDE_CARD);
        } else if (this.secondSideCard.compareTo(pair.secondSideCard) != 0) {
            return this.secondSideCard.compareTo(pair.secondSideCard);
        } else return this.thirdSideCard.compareTo(pair.thirdSideCard);
    }
}
