package units;

import java.util.*;

/**
 * units.Hand - карманные карты
 * В зависимости от дисциплины игры, количество карманных карт может быть разное
 */
// TODO: 01.03.18 объеденить hand и board
public class Hand {
    private final int cardsInHandCount;
    private List<Card> cards;

    public Hand(int cardsInHandCount) {
        cards = new ArrayList<>();
        this.cardsInHandCount = cardsInHandCount;
    }

    public Hand(HashSet<Card> cards, int cardsInHandCount) {
        this(cardsInHandCount);
        if (cardsInHandCount == cards.size()) {
            this.cards = new ArrayList<>(cards);
        } else throw new ExceptionInInitializerError("Cards count doesn't equal to cardsInHandCount");
    }

    public List<Card> getCards() {
        return cards;
    }

    public void sort() {
        Collections.sort(this.cards);
    }

    public void sort(Comparator<Card> comparator){
        Collections.sort(this.cards, comparator);
    }

    public boolean addCardInHand(Card card) {
        return insertNewCard(card);
    }

    public boolean isHandStable() {
        return cards.size() == cardsInHandCount;
    }

    private boolean insertNewCard(Card card) {
        if (cards.size() < cardsInHandCount && !cards.contains(card)) {
            return cards.add(card);
        } else return false;
    }
}
