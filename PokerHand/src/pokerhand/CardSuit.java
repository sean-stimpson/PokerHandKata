package pokerhand;

/**
 * Enum's  for designating card suits
 */
public enum CardSuit {
    SPADES('S'), HEARTS('H'), CLUBS('C'), DIAMONDS('D');

    private final char suit;

    CardSuit(char inSuit) {
        suit = inSuit;
    }

    public char getSuit() {
        return this.suit;
    }
}
