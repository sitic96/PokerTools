import enums.BoardState;

import java.util.HashSet;

public class Board {
    private HashSet<Card> cards;
    private final int cardsInBoardCount = 5;

    public Board() {
        this.cards = new HashSet<>();
    }

    public Board(HashSet<Card> cards) {
        this();
        if (cards.size() <= cardsInBoardCount) {
            this.cards = cards;
        } else {
            throw new ExceptionInInitializerError("Cards count can't be more than " + cardsInBoardCount);
        }
    }

    public boolean addCardToBoard(Card card) {
        return insertNewCard(card);
    }

    private boolean insertNewCard(Card card) {
        if (cards.size() <= cardsInBoardCount) {
            return cards.add(card);
        } else {
            return false;
        }
    }

    public BoardState boardState() {
        if (cards.size() == 3) {
            return BoardState.FLOP;
        } else if (cards.size() == 4) {
            return BoardState.TERN;
        } else if (cards.size() == 5) {
            return BoardState.RIVER;
        } else {
            return BoardState.INCOMPLETE;
        }
    }
}
