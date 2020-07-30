package pokerhand;

/**
 * Enum's for deisgnating card values.
 */
public enum CardValues {
    TWO('2', 2), THREE('3', 3), FOUR('4', 4),
    FIVE('5', 5), SIX('6', 6), SEVEN('7', 7),
    EIGHT('8', 8), NINE('9', 9), TEN('T', 10),
    JACK('J', 11), QUEEN('Q', 12), KING('K', 13),
    ACE('A', 14);
    private final char valueText;
    private final int valueInt;

    /**
     * Assigns a card values in int and char form
     *
     * @param inValueText Char form of card value
     * @param inValue     Int form of card value
     */
    CardValues(char inValueText, int inValue) {
        this.valueText = inValueText;
        this.valueInt = inValue;
    }

    /**
     * Returns card value as char
     *
     * @return char of card value
     */
    public char getValueText() {
        return this.valueText;
    }

    /**
     * Returns card value as int
     *
     * @return int of card value
     */
    public int getValueInt() {
        return this.valueInt;
    }
}