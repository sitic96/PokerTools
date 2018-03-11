package combination;

import units.Card;

import java.util.List;

public class HighCard extends Combination {

    protected final Integer POWER = 1;

    public HighCard(List<Card> cards) {
        super(cards);
    }

    @Override
    protected Card determineSideCard() {
        return CARDS.get(1);
    }

    @Override
    protected Card determineHighCard() {
        return CARDS.get(0);
    }

    @Override
    protected int compareWithSameCombination(Combination combination) {
        HighCard highCard = (HighCard) combination;

        for (int i = 0; i < CARDS.size(); i++) {
            if (CARDS.get(i).compareTo(highCard.CARDS.get(i)) != 0) {
                return CARDS.get(i).compareTo(highCard.CARDS.get(i));
            }
        }
        return 0;
    }
}
