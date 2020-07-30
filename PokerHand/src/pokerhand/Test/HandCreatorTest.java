package pokerhand.Test;

import pokerhand.Card;
import pokerhand.HandCreator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class HandCreatorTest {
    final HandCreator creator = new HandCreator();

    @Test
    public void HandCreatorTester() {
        Card testOne = new Card('A', 'S');
        Card testTwo = new Card('9', 'H');
        Card testThree = new Card('T', 'D');
        Card testFour = new Card('4', 'S');
        Card testFive = new Card('3', 'H');
        ArrayList<Card> test = new ArrayList<>(Arrays.asList(testOne, testTwo, testThree, testFour, testFive));
        ArrayList<Card> testSubject = creator.getHand("AS 9H TD 4S 3H");
        boolean shouldBeTrue = false;
        for (int i = 0; i < testSubject.size(); i++) {
            if (testSubject.get(i).getCardText().equals(test.get(i).getCardText())) {
                shouldBeTrue = true;
                break;
            }
        }
        assertTrue(shouldBeTrue);
    }

}