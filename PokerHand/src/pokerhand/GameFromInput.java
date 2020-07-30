package pokerhand;

import java.util.Scanner;

/**
 * GameFromInput class runs a game from user input in the console.
 */
public class GameFromInput {
    //Member Variables
    PokerHand white;
    PokerHand black;
    int exit;

    /**
     * runGameFromInput Prompts the user for input then calls the enterHandValues to validate
     * input and assign poker hands.
     */
    public void runGameFromInput() {
        HandCompare compare = new HandCompare();
        while (exit != -1) {
            System.out.println("Please enter 5 card values separated " +
                    "by a space. For example: 2D 3C 4C 5H 9D. or -1 to exit");
            white = enterHandValues("White");
            black = enterHandValues("Black");
            System.out.println(compare.compareHands(white, black));
        }
    }

    /**
     * enterHandValues method validates user input and returns a PokerHand object.
     *
     * @param inColor String designating which color hand the input is for
     * @return PokerHand created for game.
     */
    public PokerHand enterHandValues(String inColor) {
        Scanner in = new Scanner(System.in);
        PokerHand tempHand = null;
        String input = "";
        exit = 0;
        while (exit != -1) {
            System.out.println("Please enter Cards for " + inColor);
            try {
                input = in.nextLine();
                tempHand = new PokerHand(input);
            } catch (Exception NullPointerException) {
                if (input.equals("-1")) {
                    System.out.println("Thanks for playing");
                    System.exit(0);
                }

                System.out.println("Sorry that input didn't work. Please try Again");
            }
            if (tempHand != null) {
                return tempHand;
            }
        }
        return null;

    }
}
