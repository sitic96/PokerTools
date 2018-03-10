import enums.BoardState;
import enums.Mast;
import exceptions.BoardStateException;
import exceptions.NoCardsException;
import units.Board;
import units.Card;
import units.Hand;

import java.util.*;

public class Generator {

    private final int MASTS_COUNT = 4;
    private final int CARDS_IN_EACH_MAST_COUNT = 13;
    private final Dictionary<Integer, Card> CARDS;
    private HashSet<Integer> usedCards;
    private final Random RANDOM;

    public Generator() {
        CARDS = generateCardsDeck();
        RANDOM = new Random();
    }

    public Card nextCard() throws NoCardsException {
        if (usedCards.size() < CARDS.size()) {
            int randomCardNumber = RANDOM.nextInt(MASTS_COUNT * CARDS_IN_EACH_MAST_COUNT);
            while (usedCards.contains(randomCardNumber)) {
                randomCardNumber = RANDOM.nextInt(MASTS_COUNT * CARDS_IN_EACH_MAST_COUNT);
            }
            usedCards.add(randomCardNumber);
            return CARDS.get(randomCardNumber);
        } else {
            throw new NoCardsException("The deck is full");
        }
    }

    public Hand nextHand(int cardsCount) throws NoCardsException {
        HashSet<Card> generatedHand = new HashSet<Card>();
        if ((usedCards.size() + cardsCount <= CARDS.size()) && (cardsCount > 0)) {
            for (int i = 0; i < cardsCount; i++) {
                generatedHand.add(nextCard());
            }
            return new Hand(generatedHand, cardsCount);
        } else {
            throw new NoCardsException("The deck is full");
        }
    }

    public Board nextBoard(int cardsCount) throws NoCardsException {
        HashSet<Card> generatedHand = new HashSet<Card>();
        if ((usedCards.size() + cardsCount <= CARDS.size()) && (cardsCount > 0)) {
            for (int i = 0; i < cardsCount; i++) {
                generatedHand.add(nextCard());
            }
            return new Board(generatedHand);
        } else {
            throw new NoCardsException("The deck is full");
        }
    }

    public Board nextFlop() throws NoCardsException {
        return nextBoard(3);
    }

    public Board nextTurn() throws NoCardsException {
        return nextBoard(4);
    }

    public Board nextRiver() throws NoCardsException {
        return nextBoard(5);
    }

    public Board nextCompleteBoard(HashSet<Card> currentBoard) throws BoardStateException, NoCardsException {
        if (currentBoard.size() > 0 && currentBoard.size() < 5) {
            return nextCompleteBoard(new Board(currentBoard));
        } else {
            throw new BoardStateException("units.Board state is incorrect for this case");
        }
    }

    public Board nextCompleteBoard(Board currentBoard) throws NoCardsException {
        while (currentBoard.boardState() != BoardState.RIVER) {
            currentBoard.addCardToBoard(nextCard());
        }
        return currentBoard;
    }

    public void restart() {
        usedCards.clear();
    }

    private Dictionary<Integer, Card> generateCardsDeck() {
        Dictionary<Integer, Card> cards = new Hashtable<Integer, Card>(MASTS_COUNT * CARDS_IN_EACH_MAST_COUNT);
        usedCards = new HashSet<Integer>();
        for (Mast mast : Mast.values()) {
            /**
             * Цикл начинается с 2 т. к. минимальная карта в колоде имеет
             * value = 2
             */
            for (int j = 2; j < CARDS_IN_EACH_MAST_COUNT + 2; j++) {
                //todo оторвать себе руки за это
                //todo придумать нормальное решение
                /**
                 * cards.size() - ключ, уникальное значение по которому записывается каждая новая карта
                 * j - value карты
                 * mast - масть для текущей карты
                 */
                cards.put(cards.size(), new Card(j, mast));
            }
        }
        return cards;
    }
}
