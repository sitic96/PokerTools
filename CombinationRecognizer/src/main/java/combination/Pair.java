package combination;

import units.Card;

import java.util.HashSet;
import java.util.List;

public class Pair extends Combination {
    public Pair(int power, HashSet<Card> cards) {
        super(power, cards);
    }

    public Pair(int power, List<Card> cards) {
        super(power, cards);
    }
}
