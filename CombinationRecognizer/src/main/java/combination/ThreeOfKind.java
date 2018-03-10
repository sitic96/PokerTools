package combination;

import units.Card;

import java.util.HashSet;
import java.util.List;

public class ThreeOfKind extends Combination {
    private Card secondSideCard;

    public ThreeOfKind(List<Card> cards) {
        super(cards);
        SECOND_SIDE_CARD = determineSecondSideCard();
    }

    private Card determineSecondSideCard() {

    }

    @Override
    protected Card determineSideCard() {
        if (CARDS.get(0).compareTo(CARDS.get(2)) == 0) {
            secondSideCard = CARDS.get(4);
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
        ThreeOfKind threeOfKind = (ThreeOfKind) combination;
        if (this.HIGH_CARD.compareTo(threeOfKind.HIGH_CARD) == 0) {
            if (this.SIDE_CARD.compareTo(threeOfKind.SIDE_CARD) == 0) {

            } else return this.SIDE_CARD.compareTo(threeOfKind.SIDE_CARD);
        } else return this.HIGH_CARD.compareTo(threeOfKind.HIGH_CARD);
    }
}
