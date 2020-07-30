package pokerhand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * GameFromFile takes in a file path and prints out resulting
 * poker games from that text file.
 */
public class GameFromFile {
    private final String filePath;
    private Scanner input;

    /**
     * Constructor creates a GameFromFile object taking in a file path
     *
     * @param inFilePath String directing program to proper txt file
     */
    public GameFromFile(String inFilePath) {
        filePath = inFilePath;
    }

    /**
     * readFile method runs poker game and prints out the results.
     */
    public String runGameFromFile() {
        HandCompare compare = new HandCompare();
        StringBuilder sb = new StringBuilder();
        PokerHand black;
        PokerHand white;
        String result = "";
        String tempLine; //used to store line to create hands from
        try {
            input = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNextLine()) {
            tempLine = input.nextLine();
            black = new PokerHand(tempLine.substring(7, 21));
            white = new PokerHand(tempLine.substring(30, 44));
            result = sb.append(compare.compareHands(white, black)).append("\n").toString();

        }
        return result;
    }
}
