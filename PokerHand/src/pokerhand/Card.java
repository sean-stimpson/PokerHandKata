package pokerhand;

/**
 * Class creates card objects with ability to return values
 */

public class Card {
    //Member Variables
    private final String cardText;
    private CardValues value;
    private CardSuit suit;


    /**
     * Constructor creates a card with two char parameters
     *
     * @param inValue sets card's value
     * @param inSuit  sets card's suit
     */
    public Card(char inValue, char inSuit) {
        StringBuilder sb = new StringBuilder();
        cardText = sb.append(inValue).append(inSuit).toString();
        this.calcCardSuit(inSuit);
        this.calcValue(inValue);
    }

    /**
     * Method converts value of card into int for easy comparison.
     */
    private void calcCardSuit(char inSuit) {
        switch (inSuit) {
            case 'C' -> suit = CardSuit.CLUBS;
            case 'D' -> suit = CardSuit.DIAMONDS;
            case 'H' -> suit = CardSuit.HEARTS;
            case 'S' -> suit = CardSuit.SPADES;
        }
    }

    /**
     * Assigns card an enum for value
     *
     * @param inValue int indicating which enum to choose
     */
    private void calcValue(int inValue) {
        switch (inValue) {
            case '2' -> value = CardValues.TWO;
            case '3' -> value = CardValues.THREE;
            case '4' -> value = CardValues.FOUR;
            case '5' -> value = CardValues.FIVE;
            case '6' -> value = CardValues.SIX;
            case '7' -> value = CardValues.SEVEN;
            case '8' -> value = CardValues.EIGHT;
            case '9' -> value = CardValues.NINE;
            case 'T' -> value = CardValues.TEN;
            case 'J' -> value = CardValues.JACK;
            case 'Q' -> value = CardValues.QUEEN;
            case 'K' -> value = CardValues.KING;
            case 'A' -> value = CardValues.ACE;
        }
    }

    /**
     * Gets card value as int
     *
     * @return A int representing card value.
     */
    public int getValue() {
        return this.value.getValueInt();
    }

    /**
     * Gets card suit as char
     *
     * @return card suit
     */
    public char getSuit() {
        return this.suit.getSuit();
    }

    /**
     * Gets value as a char instead of int
     *
     * @return char of card value.
     */
    public char getValueText() {
        return this.value.getValueText();
    }

    /**
     * Gets String representing cards value
     *
     * @return cards value as a String
     */
    public String getCardText() {
        return cardText;
    }
}
