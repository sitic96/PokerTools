import java.util.HashSet;

public class Hand {
    private final int cardsInHandCount;
    private HashSet<Card> cards;

    public Hand(int cardsInHandCount) {
        cards = new HashSet<>(cardsInHandCount);
        this.cardsInHandCount = cardsInHandCount;
    }

    public Hand(HashSet<Card> cards, int cardsInHandCount) {
        this(cardsInHandCount);
        if (cardsInHandCount == cards.size()) {
            this.cards = cards;
        } else throw new ExceptionInInitializerError("Cards count doesn't equal to cardsInHandCount");
    }

    public HashSet<Card> getCards() {
        return cards;
    }

    public boolean addCardInHand(Card card) {
        return insertNewCard(card);
    }

    public boolean isHandStable() {
        return cards.size() == cardsInHandCount;
    }

    private boolean insertNewCard(Card card) {
        if (cards.size() < cardsInHandCount) {
            return cards.add(card);
        } else return false;
    }
}
