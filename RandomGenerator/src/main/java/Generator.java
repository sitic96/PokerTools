
import enums.BoardState;
import enums.Mast;

import java.util.*;

public class Generator {

    private final int MASTS_COUNT = 4;
    private final int CARDS_IN_EACH_MAST_COUNT = 13;
    private final Dictionary<Integer, Card> CARDS;
    private HashSet<Integer> usedCards;
    private final Random RANDOM;

    public Generator() {
        CARDS = generateCards();
        RANDOM = new Random();
    }

    public Card nextCard() throws Exception {
        if (usedCards.size() < CARDS.size()) {
            int randomCardNumber = RANDOM.nextInt(MASTS_COUNT * CARDS_IN_EACH_MAST_COUNT);
            while (usedCards.contains(randomCardNumber)) {
                randomCardNumber = RANDOM.nextInt(MASTS_COUNT * CARDS_IN_EACH_MAST_COUNT);
            }
            usedCards.add(randomCardNumber);
            return CARDS.get(randomCardNumber);
        } else {
            // todo добавить кастомную ошибку
            throw new Exception("No cards");
        }
    }

    public Hand nextHand(int cardsCount) throws Exception {
        HashSet<Card> generatedHand = new HashSet<Card>();
        if ((usedCards.size() + cardsCount <= CARDS.size()) && (cardsCount > 0)) {
            for (int i = 0; i < cardsCount; i++) {
                generatedHand.add(nextCard());
            }
            return new Hand(generatedHand, cardsCount);
        } else {
            // todo добавить кастомную ошибку
            throw new Exception("No cards");
        }
    }

    public Board nextBoard(int cardsCount) throws Exception {
        HashSet<Card> generatedHand = new HashSet<Card>();
        if ((usedCards.size() + cardsCount <= CARDS.size()) && (cardsCount > 0)) {
            for (int i = 0; i < cardsCount; i++) {
                generatedHand.add(nextCard());
            }
            return new Board(generatedHand);
        } else {
            // todo добавить кастомную ошибку
            throw new Exception("No cards");
        }
    }

    public Board nextFlop() throws Exception {
        return nextBoard(3);
    }

    public Board nextTurn() throws Exception {
        return nextBoard(4);
    }

    public Board nextRiver() throws Exception {
        return nextBoard(5);
    }

    public Board nextCompleteBoard(HashSet<Card> currentBoard) throws Exception {
        if (currentBoard.size() > 0 && currentBoard.size() < 5) {
            return nextCompleteBoard(new Board(currentBoard));
        }
        else {
            throw new Exception("Board state is incorrect for this case");
        }
    }

    public Board nextCompleteBoard(Board currentBoard) throws Exception {
        while (currentBoard.boardState() != BoardState.RIVER) {
            currentBoard.addCardToBoard(nextCard());
        }
        return currentBoard;
    }

    public void restart() {
        usedCards.clear();
    }

    //TODO RENAME
    private Dictionary<Integer, Card> generateCards() {
        Dictionary<Integer, Card> cards = new Hashtable<Integer, Card>(MASTS_COUNT * CARDS_IN_EACH_MAST_COUNT);
        usedCards = new HashSet<Integer>();
        for (Mast m : Mast.values()) {
            for (int j = 2; j < CARDS_IN_EACH_MAST_COUNT + 2; j++) {
                //todo оторвать себе руки за это
                //todo придумать нормальное решение
                cards.put(cards.size(), new Card(j, m));
            }
        }
        return cards;
    }
}
