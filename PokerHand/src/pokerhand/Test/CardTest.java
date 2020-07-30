package pokerhand.Test;

import pokerhand.Card;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CardTest {
    final Card testCard = new Card('2', 'H');

    @Test
    public void CardConstructorTest() {
        assertNotNull(testCard);
    }

    @Test
    public void getValueTest() {
        Assert.assertEquals(2, testCard.getValue());
    }

    @Test
    public void getSuitTest() {
        Assert.assertEquals('H', testCard.getSuit());
    }

    @Test
    public void getValueTextTest() {
        Assert.assertEquals('2', testCard.getValueText());
    }

    @Test
    public void getCardTextTest() {
        Assert.assertEquals("2H", testCard.getCardText());
    }
}