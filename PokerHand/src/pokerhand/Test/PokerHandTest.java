package pokerhand.Test;

import pokerhand.PokerHand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandTest {
    PokerHand testHand;

    @Before
    public void setUp() {
        testHand = new PokerHand("2S 3H 4D 5C TS");
    }

    @Test
    public void PokerHandTestConstructor() {
        assertNotNull(testHand);
    }

    @Test
    public void getValueIntTest() {
        assertEquals(2, testHand.getValueInt(0));
        assertEquals(3, testHand.getValueInt(1));
        assertEquals(4, testHand.getValueInt(2));
        assertEquals(5, testHand.getValueInt(3));
        assertEquals(10, testHand.getValueInt(4));
    }

    @Test
    public void setHandTest() {
        testHand.setHand("3D 4h 9c 2d ts");
        assertEquals(2, testHand.getValueInt(0));
        assertEquals(3, testHand.getValueInt(1));
        assertEquals(4, testHand.getValueInt(2));
        assertEquals(9, testHand.getValueInt(3));
        assertEquals(10, testHand.getValueInt(4));

    }

    @Test
    public void handToString() {
        assertEquals("High Card 10", testHand.handToString());
    }

    @Test
    public void sortHand() {
        testHand.setHand("as th 3d 4h tc");
        assertEquals("3D", testHand.cardToString(0));
        assertEquals("4H", testHand.cardToString(1));
        assertEquals("TH", testHand.cardToString(2));
        assertEquals("TC", testHand.cardToString(3));
        assertEquals("AS", testHand.cardToString(4));

    }

}