package pokerhand;

import java.util.ArrayList;

/**
 * Class creates a hand creator object for creating hands either from an array of strings
 * or from a full string. Puts cards in an Array List.
 */
public class HandCreator {

    public HandCreator() {

    }

    /**
     * Creates a card array from a String array
     *
     * @param inHand String array to create card array
     * @return PokerHand.Card arraylist for poker hand.
     */
    public ArrayList<Card> getHand(String[] inHand) {

        ArrayList<Card> tempHand = new ArrayList<>();
        Card tempCard;
        for (int i = 0; i < inHand.length; i++) {
            tempCard = new Card(inHand[i].toUpperCase().charAt(0), inHand[i].toUpperCase().charAt(1));
            tempHand.add(i, tempCard);
        }
        return tempHand;
    }

    /**
     * Creates a card array from a full String
     *
     * @param inHand String to create array from.
     * @return PokerHand.Card arraylist for poker hand.
     */
    public ArrayList<Card> getHand(String inHand) {
        ArrayList<Card> tempHand = new ArrayList<>();
        Card tempCard;
        int counter = 0;
        for (int i = 0; i < inHand.length(); i += 3) {
            tempCard = new Card(inHand.toUpperCase().charAt(i), inHand.toUpperCase().charAt(i + 1));
            tempHand.add(counter, tempCard);
            counter++;
        }
        return tempHand;
    }
}
