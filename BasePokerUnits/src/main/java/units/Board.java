package units;

import enums.BoardState;

import java.util.*;

// todo переписать этот маразм
// TODO: 21.02.18  
/**
 * units.Board - это выложенные дилером карты
 * Может быть в одном из трех состояний:
 * Флоп - выложены 3 карты
 * Терн - выложены 4 карты
 * Ривер - выложены все (5) карт
 */
public class Board {
    private List<Card> cards;
    private final int MAX_CARDS_IN_BOARD_COUNT = 5;

    public Board() {
        this.cards = new ArrayList<>();
    }

    public Board(HashSet<Card> cards) {
        this();
        if (cards.size() <= MAX_CARDS_IN_BOARD_COUNT) {
            this.cards = new ArrayList<>(cards);
        } else {
            throw new ExceptionInInitializerError("Cards count can't be more than " + MAX_CARDS_IN_BOARD_COUNT);
        }
    }

    public boolean addCardToBoard(Card card) {
        return insertNewCard(card);
    }

    private boolean insertNewCard(Card card) {
        if (cards.size() <= MAX_CARDS_IN_BOARD_COUNT && !cards.contains(card)) {
            return cards.add(card);
        } else {
            return false;
        }
    }

    public void sort() {
        Collections.sort(cards);
    }

    public void sort(Comparator<Card> comparator){
        Collections.sort(this.cards, comparator);
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

    public List<Card> getCards() {
        return cards;
    }
}
