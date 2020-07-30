package pokerhand.main;

import pokerhand.*;

/** Driver class for Poker Hand kata. Able to either manually enter input via the arrays, enter input
 * via the console to play the poker game. It is set up to read the ExampleCards.txt file in the
 * directory by default. This file represents the sample input given by the original Kata.
 *
 * @author Sean Stimpson
 * @version 1.0
 */
public class PokerHandDriver {

    public static void main (String [] args){
        //Strings and arrays for manual testing.
        String testWhiteStringOne = "2C 3H 4S 8C AH";
        String testBlackStringOne = "2H 3D 5S 9C KD";
        String [] testWhiteOne = {"2C", "3H", "4S", "8C", "AH"};
        String [] testWhiteTwo = {"2S", "8S", "AS", "QS", "3S"};
        String [] testWhiteThree = {"2C", "3H", "4S", "8C", "KH"};
        String [] testWhiteFour = {"2D", "3H", "5C", "9S", "KH"};
        String [] testBlackOne = {"2H", "3D", "5S", "9C", "KD"};
        String [] testBlackTwo = {"2H", "4S", "4C", "2D", "4H"};
        String [] testBlackThree = {"2H", "3D", "5S", "9C", "KD"};
        String [] testBlackFour = {"2H", "3D", "5S", "9C", "KD"};

        //PokerHand objects for manual testing
        PokerHand white = new PokerHand(testWhiteOne);
        PokerHand black = new PokerHand(testBlackOne);
        HandCompare judge = new HandCompare();

        // *** Uncomment below to run game from user input ***
/*
        GameFromInput inputGame = new GameFromInput();
        inputGame.runGameFromInput();
*/



        // ****Uncomment below to use manual array/string test cases *****
/*
        System.out.println(judge.compareHands(white, black));
        white.setHand(testWhiteTwo);
        black.setHand(testBlackTwo);
        System.out.println(judge.compareHands(white, black));
        white.setHand(testWhiteThree);
        black.setHand(testBlackThree);
        System.out.println(judge.compareHands(white, black));
        white.setHand(testWhiteFour);
        black.setHand(testBlackFour);
        System.out.println(judge.compareHands(white, black));
        white.setHand(testWhiteStringOne);
        black.setHand(testBlackStringOne);
        System.out.println(judge.compareHands(white, black));
*/

        // ***** Comment out to ignore file input case ***
        GameFromFile fileGame = new GameFromFile("ExampleCards.txt");
        System.out.println(fileGame.runGameFromFile());


    }
}
