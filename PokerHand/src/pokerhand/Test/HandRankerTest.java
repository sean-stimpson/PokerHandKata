package pokerhand.Test;

import pokerhand.HandRanker;
import pokerhand.PokerHand;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandRankerTest {


    final PokerHand testFlush = new PokerHand("2D 3D 7D 5D 6D");
    final PokerHand testStraightFlush = new PokerHand("2D 3D 4D 5D 6D");
    final PokerHand testPair = new PokerHand("2D 2H 3D 4D 6H");
    final PokerHand testThreeKind = new PokerHand("2D 2H 2C KH AH");
    final PokerHand testFullHouse = new PokerHand("2D 2H 2C 6H 6D");
    final PokerHand testFourKind = new PokerHand("2D 2H 2S 2C 5H");
    final PokerHand testTwoPair = new PokerHand("5D 5H 6D 6H AH");
    final PokerHand testHighCard = new PokerHand("2D 3H 5S TD AS");
    final PokerHand testStraight = new PokerHand("2D 3H 4D 5H 6C");
    final HandRanker ranker = new HandRanker(testFlush.getHand());

    @Test
    public void isFlush() {
        assertTrue(ranker.isFlush());
        ranker.setRanker(testStraightFlush.getHand());
        assertTrue(ranker.isFlush());
        ranker.setRanker(testStraight.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testPair.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testThreeKind.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testFullHouse.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testFourKind.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testTwoPair.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testHighCard.getHand());
        assertFalse(ranker.isFlush());
    }

    @Test
    public void isStraightFlush() {
        ranker.setRanker(testStraightFlush.getHand());
        assertTrue(ranker.isStraightFlush());
        ranker.setRanker(testStraight.getHand());
        assertFalse(ranker.isStraightFlush());
        ranker.setRanker(testPair.getHand());
        assertFalse(ranker.isStraightFlush());
        ranker.setRanker(testThreeKind.getHand());
        assertFalse(ranker.isStraightFlush());
        ranker.setRanker(testFullHouse.getHand());
        assertFalse(ranker.isStraightFlush());
        ranker.setRanker(testFourKind.getHand());
        assertFalse(ranker.isStraightFlush());
        ranker.setRanker(testTwoPair.getHand());
        assertFalse(ranker.isStraightFlush());
        ranker.setRanker(testHighCard.getHand());
        assertFalse(ranker.isStraightFlush());
    }

    @Test
    public void isPair() {
        ranker.setRanker(testPair.getHand());
        assertTrue(ranker.isPair());
        ranker.setRanker(testStraight.getHand());
        assertFalse(ranker.isPair());
        ranker.setRanker(testThreeKind.getHand());
        assertTrue(ranker.isPair());
        ranker.setRanker(testFullHouse.getHand());
        assertTrue(ranker.isPair());
        ranker.setRanker(testFourKind.getHand());
        assertTrue(ranker.isPair());
        ranker.setRanker(testTwoPair.getHand());
        assertTrue(ranker.isPair());
        ranker.setRanker(testHighCard.getHand());
        assertFalse(ranker.isPair());
        ranker.setRanker(testStraightFlush.getHand());
        assertFalse(ranker.isPair());
    }

    @Test
    public void isTwoPair() {
        ranker.setRanker(testTwoPair.getHand());
        assertTrue(ranker.isTwoPair());
        ranker.setRanker(testStraight.getHand());
        assertFalse(ranker.isTwoPair());
        ranker.setRanker(testPair.getHand());
        assertFalse(ranker.isTwoPair());
        ranker.setRanker(testThreeKind.getHand());
        assertFalse(ranker.isTwoPair());
        ranker.setRanker(testFullHouse.getHand());
        assertTrue(ranker.isTwoPair());
        ranker.setRanker(testFourKind.getHand());
        assertTrue(ranker.isTwoPair());
        ranker.setRanker(testStraightFlush.getHand());
        assertFalse(ranker.isTwoPair());
        ranker.setRanker(testHighCard.getHand());
        assertFalse(ranker.isTwoPair());

    }

    @Test
    public void isThreeKind() {
        ranker.setRanker(testThreeKind.getHand());
        assertTrue(ranker.isThreeKind());
        ranker.setRanker(testStraight.getHand());
        assertFalse(ranker.isThreeKind());
        ranker.setRanker(testPair.getHand());
        assertFalse(ranker.isThreeKind());
        ranker.setRanker(testTwoPair.getHand());
        assertFalse(ranker.isThreeKind());
        ranker.setRanker(testFullHouse.getHand());
        assertTrue(ranker.isThreeKind());
        ranker.setRanker(testFourKind.getHand());
        assertTrue(ranker.isThreeKind());
        ranker.setRanker(testStraightFlush.getHand());
        assertFalse(ranker.isThreeKind());
        ranker.setRanker(testHighCard.getHand());
        assertFalse(ranker.isThreeKind());
    }

    @Test
    public void isStraight() {
        assertTrue(ranker.isFlush());
        ranker.setRanker(testStraightFlush.getHand());
        assertTrue(ranker.isFlush());
        ranker.setRanker(testStraight.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testPair.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testThreeKind.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testFullHouse.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testFourKind.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testTwoPair.getHand());
        assertFalse(ranker.isFlush());
        ranker.setRanker(testHighCard.getHand());
        assertFalse(ranker.isFlush());
    }

    @Test
    public void isFullHouse() {
        ranker.setRanker(testFullHouse.getHand());
        assertTrue(ranker.isFullHouse());
        ranker.setRanker(testStraightFlush.getHand());
        assertFalse(ranker.isFullHouse());
        ranker.setRanker(testStraight.getHand());
        assertFalse(ranker.isFullHouse());
        ranker.setRanker(testPair.getHand());
        assertFalse(ranker.isFullHouse());
        ranker.setRanker(testThreeKind.getHand());
        assertFalse(ranker.isFullHouse());
        ranker.setRanker(testFourKind.getHand());
        assertFalse(ranker.isFullHouse());
        ranker.setRanker(testTwoPair.getHand());
        assertFalse(ranker.isFullHouse());
        ranker.setRanker(testHighCard.getHand());
        assertFalse(ranker.isFullHouse());
    }

    @Test
    public void isFourKind() {
        ranker.setRanker(testFourKind.getHand());
        assertTrue(ranker.isFourKind());
        ranker.setRanker(testStraightFlush.getHand());
        assertFalse(ranker.isFourKind());
        ranker.setRanker(testStraight.getHand());
        assertFalse(ranker.isFourKind());
        ranker.setRanker(testPair.getHand());
        assertFalse(ranker.isFourKind());
        ranker.setRanker(testThreeKind.getHand());
        assertFalse(ranker.isFourKind());
        ranker.setRanker(testFullHouse.getHand());
        assertFalse(ranker.isFourKind());
        ranker.setRanker(testTwoPair.getHand());
        assertFalse(ranker.isFourKind());
        ranker.setRanker(testHighCard.getHand());
        assertFalse(ranker.isFourKind());
    }

    @Test
    public void getHandRank() {
        ranker.setRanker(testHighCard.getHand());
        assertEquals(0, ranker.getHandRank());
        ranker.setRanker(testPair.getHand());
        assertEquals(1, ranker.getHandRank());
        ranker.setRanker(testTwoPair.getHand());
        assertEquals(2, ranker.getHandRank());
        ranker.setRanker(testThreeKind.getHand());
        assertEquals(3, ranker.getHandRank());
        ranker.setRanker(testStraight.getHand());
        assertEquals(4, ranker.getHandRank());
        ranker.setRanker(testFlush.getHand());
        assertEquals(5, ranker.getHandRank());
        ranker.setRanker(testFullHouse.getHand());
        assertEquals(6, ranker.getHandRank());
        ranker.setRanker(testFourKind.getHand());
        assertEquals(7, ranker.getHandRank());
        ranker.setRanker(testStraightFlush.getHand());
        assertEquals(8, ranker.getHandRank());
    }

}