package pokerhand.Test;

import pokerhand.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameFromFileTest {
    final GameFromFile fileTest = new GameFromFile("ExampleCards.txt");

    @Test
    public void GameFromFileTester() {
        assertNotNull(fileTest);
    }

    @Test
    public void runGameFromFile() {
        String testString = fileTest.runGameFromFile();
        String result = "White wins. - with High Card Ace\n" +
                "Black wins. - with Full House: 4 over 2\n" +
                "Black wins. - with High Card 9\n" +
                "Tie.\n";
        assertEquals(testString, result);
    }

}