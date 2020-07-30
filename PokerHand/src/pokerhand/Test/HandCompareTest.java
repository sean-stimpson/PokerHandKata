package pokerhand.Test;

import pokerhand.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandCompareTest {
    final PokerHand testFlush = new PokerHand("2D 3D 4D 5D 6D");
    final PokerHand testStraightFlush = new PokerHand("2D 3D 4D 5D 6D");
    final PokerHand testPair = new PokerHand("2D 2H 3D 4D 6H");
    final PokerHand testThreeKind = new PokerHand("2D 2H 2C KH AH");
    final PokerHand testFullHouse = new PokerHand("2D 2H 2C 6H 6D");
    final PokerHand testFourKind = new PokerHand("2D 2H 2S 2C 5H");
    final PokerHand testTwoPair = new PokerHand("5D 5H 6D 6H AH");
    final PokerHand testHighCard = new PokerHand("2D 3H 5S TD AS");
    final PokerHand testStraight = new PokerHand("2D 3H 4D 5H 6C");

    @Test
    public void testCompareHands() {
        HandCompare compare = new HandCompare();
        String testOne = compare.compareHands(testFlush, testStraightFlush);
        String testTwo = compare.compareHands(testFlush, testPair);
        String testThree = compare.compareHands(testFlush, testFlush);
        String testFour = compare.compareHands(testThreeKind, testFullHouse);
        String testFive = compare.compareHands(testFourKind, testTwoPair);
        String testSix = compare.compareHands(testHighCard, testStraight);
        assertEquals("Tie.", testOne);
        assertEquals("White wins. - with Straight Flush with high value: 6", testTwo);
        assertEquals("Tie.", testThree);
        assertEquals("Black wins. - with Full House: 2 over 6", testFour);
        assertEquals("White wins. - with Four of a kind with high value: 2", testFive);
        assertEquals("Black wins. - with Straight with high value: 6", testSix);
    }
}
