package pokerhand;

/**
 * PokerHand.HandCompare object takes two PokerHands, compares them, and
 * declares a winner.
 */

public class HandCompare {
    //Member variables
    private String comparison;
    private int outcome;
    private int result;

    /**
     * Constructor creates a PokerHand.HandCompare object and
     * initializes member variables with default values.
     */
    public HandCompare() {
        comparison = "Invalid Data";
        outcome = 999;
    }

    /**
     * Method compares two PokerHands and returns a winner.
     *
     * @param whiteHand First Hand
     * @param blackHand Second Hand
     * @return Returns String stating winner.
     */
    public String compareHands(PokerHand whiteHand, PokerHand blackHand) {
        result = whiteHand.getHandRank() - blackHand.getHandRank();
        if (result > 0) {
            outcome = 1;
        } else if (result < 0) {
            outcome = 2;
        } else {
            outcome = this.tieBreaker(whiteHand, blackHand);
        }
        switch (outcome) {
            case 0 -> comparison = ("Tie.");
            case 1 -> comparison = ("White wins. - with " + whiteHand.handToString());
            case 2 -> comparison = ("Black wins. - with " + blackHand.handToString());
            default -> comparison = ("Invalid Data Entered");
        }
        return comparison;
    }

    /**
     * Method called in case of tie breaker to compare highest cards in hand.
     *
     * @param whiteHand First Hand (White)
     * @param blackHand Second Hand (Black)
     * @return integer to be applied to outcome variable.
     */
    private int tieBreaker(PokerHand whiteHand, PokerHand blackHand) {
        //loop goes through both hands comparing the highest cards
        int tieBreakerIndex = 4;
        while (tieBreakerIndex >= 0) {
            result = whiteHand.getValueInt(tieBreakerIndex) - blackHand.getValueInt(tieBreakerIndex);
            if (result > 0) {
                whiteHand.setHighCardValue(tieBreakerIndex);
                return 1;
            } else if (result < 0) {
                blackHand.setHighCardValue(tieBreakerIndex);
                return 2;
            }
            tieBreakerIndex--;
        }
        //In case of absolute tie
        return 0;

    }

}
