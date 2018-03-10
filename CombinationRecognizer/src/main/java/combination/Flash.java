package combination;

import units.Card;

import java.util.List;

public class Flash extends Combination {
    protected final Integer POWER = 6;

    public Flash(List<Card> cards) {
        super(cards);
    }

    @Override
    protected Card determineSideCard() {
        return null;
    }

    @Override
    protected Card determineHighCard() {
        return CARDS.get(0);
    }

    @Override
    protected int compareWithSameCombination(Combination combination) {
        Flash flash = (Flash) combination;

        if (this.HIGH_CARD.compareTo(flash.HIGH_CARD) == 0) {
            for (int i = 1; i < 5; i++) {
                if (CARDS.get(i).compareTo(flash.CARDS.get(i)) != 0) {
                    return CARDS.get(i).compareTo(flash.CARDS.get(i));
                }
            }
            return 0;
        } else {
            return this.HIGH_CARD.compareTo(flash.HIGH_CARD);
        }
    }
}
