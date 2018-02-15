
import enums.BoardState;
import org.junit.After;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class GeneratorTest {

    Generator generator;
    HashSet<Card> cards;
    final Integer CARDS_COUNT = 52;

    @org.junit.Before
    public void setUp() throws Exception {
        generator = new Generator();
        cards = new HashSet<Card>();
    }

    @After
    public void tearDown() throws Exception {
        generator.restart();
        cards.clear();
    }

    @org.junit.Test
    public void nextCardNotNullTest() throws Exception {
        for (int i = 0; i < CARDS_COUNT; i++) {
            Card next = generator.nextCard();
            assertNotEquals(null, next);
        }
    }

    @Test
    public void cardsUniqueTest() throws Exception {
        for (int i = 0; i < CARDS_COUNT; i++) {
            Card next = generator.nextCard();
            assertTrue(cards.add(next));
        }
    }

    @Test
    public void nextHandTest() throws Exception {
        // 52/4 = 13
        for (int i = 0; i < 13; i++) {
            Hand nextHand = generator.nextHand(4);
            for (Card c : nextHand.getCards()) {
                assertTrue(cards.add(c));
            }
        }
    }

    @Test
    public void nextBoardTest() throws Exception {
        Board board = generator.nextBoard(3);
        assertEquals(BoardState.FLOP, board.boardState());

        board = generator.nextCompleteBoard(board);
        assertEquals(BoardState.RIVER, board.boardState());

        board = generator.nextBoard(1);
        assertEquals(BoardState.INCOMPLETE, board.boardState());

        board = generator.nextBoard(4);
        assertEquals(BoardState.TERN, board.boardState());
    }

    @Test
    public void gameTest() throws Exception {
        Hand hand1 = generator.nextHand(4);
        Hand hand2 = generator.nextHand(4);
        Board board = generator.nextBoard(3);
        board.addCardToBoard(generator.nextCard());
        board.addCardToBoard(generator.nextCard());
    }
}