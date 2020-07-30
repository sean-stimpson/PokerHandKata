package pokerhand;

import java.util.ArrayList;

/**
 * PokerHand.HandRanker objects take in card arrays and evaluates their rank.
 */
public class HandRanker {
    ArrayList<Card> cards = new ArrayList<>();
    //Initialize member variables
    private char highValue;
    private char lowValue;
    private String highCardName;
    private String lowCardName;
    private String rankString;
    private int rankNumber;
    private int pairIndexTracker;

    /**
     * Constructor takes in a card array and sets the ranker up.
     *
     * @param newCard Array of cards to rank
     */
    public HandRanker(ArrayList<Card> newCard) {
        this.setRanker(newCard);
    }

    /**
     * Method sets up ranker. Can be called separately in case of hand change.
     *
     * @param newCard Array of cards to rank
     */
    public void setRanker(ArrayList<Card> newCard) {
        cards = newCard;
        rankString = rankToString();
        rankNumber = rankToNumber();
    }

    /**
     * Checks all possibilities and applies a numerical rank to a hand.
     *
     * @return integer representing hands rank (ie. pair = 1)
     */
    public int rankToNumber() {
        isHighCard();
        rankNumber = 0;
        if (isPair()) {
            rankNumber = 1;
            if (isTwoPair()) {
                rankNumber = 2;
            }
        }
        if (isThreeKind()) {
            rankNumber = 3;
        }
        if (isStraight()) {
            rankNumber = 4;
        }
        if (isFlush()) {
            rankNumber = 5;
        }
        if (isFullHouse()) {
            rankNumber = 6;
        }
        if (isFourKind()) {
            rankNumber = 7;
        }
        if (isStraightFlush()) {
            rankNumber = 8;
        }
        this.highValueString();
        return rankNumber;
    }

    /**
     * Method to set the high card of a hand in case of no other ranks.
     */
    public void isHighCard() {
        highValue = cards.get(4).getValueText();
    }

    /**
     * Checks hand to see if hand contains a flush (ie. all suits are same)
     *
     * @return True if hand is flush
     */
    public boolean isFlush() {
        char tempSuit = cards.get(0).getSuit();
        return tempSuit == cards.get(1).getSuit() &&
                tempSuit == cards.get(2).getSuit() &&
                tempSuit == cards.get(3).getSuit() &&
                tempSuit == cards.get(4).getSuit();

    }

    /**
     * Checks hand to see if it is Straight Flush
     *
     * @return True if hand is Straight flush
     */
    public boolean isStraightFlush() {
        for (int i = 0; i < 4; i++) {
            if (cards.get(i + 1).getValue() - cards.get(i).getValue() != 1
                    || cards.get(i).getSuit() != cards.get(i + 1).getSuit()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks hand to see if it contains a pair of same values and sets index for possible two pair.
     *
     * @return True if hand contains a pair.
     */
    public boolean isPair() {
        if (cards.get(0).getValueText() == cards.get(1).getValueText()) {
            highValue = cards.get(0).getValueText();
            pairIndexTracker = 0;
            return true;
        } else if (cards.get(1).getValueText() == cards.get(2).getValueText()) {
            highValue = cards.get(1).getValueText();
            pairIndexTracker = 1;
            return true;
        } else if (cards.get(2).getValueText() == cards.get(3).getValueText()) {
            highValue = cards.get(2).getValueText();
            pairIndexTracker = 2;
            return true;
        } else if (cards.get(3).getValueText() == cards.get(4).getValueText()) {
            highValue = cards.get(3).getValueText();
            pairIndexTracker = 3;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Checks hand to see if it contains two pairs.
     *
     * @return True if hand contains two pairs.
     */
    public boolean isTwoPair() {
        if (isPair()) {
            switch (pairIndexTracker) {
                case 0:
                    if (cards.get(2).getValueText() == cards.get(3).getValueText()) {
                        highValue = cards.get(2).getValueText();
                        return true;
                    }
                case 1:
                    if (cards.get(3).getValueText() == cards.get(4).getValueText()) {
                        highValue = cards.get(3).getValueText();
                        return true;
                    }
            }
        }
        return false;
    }

    /**
     * Checks to see if hand has three of same values.
     *
     * @return True if hand contains three of same values.
     */
    public boolean isThreeKind() {
        if (cards.get(0).getValueText() == cards.get(2).getValueText()) {
            highValue = cards.get(0).getValueText();
            return true;
        } else if (cards.get(2).getValueText() == cards.get(4).getValueText()) {
            highValue = cards.get(2).getValueText();
            return true;
        }
        return false;
    }

    /**
     * Checks to see if hand contains a straight.
     *
     * @return True if hand contains straight.
     */
    public boolean isStraight() {
        for (int i = 0; i < 4; i++) {
            if (cards.get(i).getValue() - cards.get(i + 1).getValue() != -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks hand for full house. Sets high and low value for toString
     *
     * @return Boolean true if hand contains a full house.
     */
    public boolean isFullHouse() {
        if (isThreeKind()) {
            if (cards.get(0).getValueText() == cards.get(2).getValueText()) {
                if (cards.get(3).getValueText() == cards.get(4).getValueText()) {
                    highValue = cards.get(0).getValueText();
                    lowValue = cards.get(3).getValueText();
                    lowCardName = lowValueString();
                    return true;
                }
            } else if (cards.get(2).getValueText() == cards.get(4).getValueText()) {
                if (cards.get(0).getValueText() == cards.get(1).getValueText()) {
                    lowValue = cards.get(0).getValueText();
                    lowCardName = lowValueString();
                    highValue = cards.get(2).getValueText();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks to see if hand contains four of a kind.
     *
     * @return Boolean true if hand contains four of a kind.
     */
    public boolean isFourKind() {
        if (cards.get(0).getValueText() == cards.get(3).getValueText()) {
            highValue = cards.get(1).getValueText();
            return true;
        } else if (cards.get(1).getValueText() == cards.get(4).getValueText()) {
            highValue = cards.get(1).getValueText();
            return true;
        }
        return false;
    }

    /**
     * Returns hand rank as a number for comparison.
     *
     * @return int representing hand rank.
     */
    public int getHandRank() {
        return this.rankNumber;
    }

    /**
     * Converts high value of deck to String for printing
     */
    public void highValueString() {
        switch (highValue) {
            case '2' -> highCardName = "2";
            case '3' -> highCardName = "3";
            case '4' -> highCardName = "4";
            case '5' -> highCardName = "5";
            case '6' -> highCardName = "6";
            case '7' -> highCardName = "7";
            case '8' -> highCardName = "8";
            case '9' -> highCardName = "9";
            case 'T' -> highCardName = "10";
            case 'J' -> highCardName = "Jack";
            case 'Q' -> highCardName = "Queen";
            case 'K' -> highCardName = "King";
            case 'A' -> highCardName = "Ace";
        }
    }

    /**
     * Converts low Value of deck to string for printing full house.
     *
     * @return String representing low value of deck for Full house's
     */
    public String lowValueString() {
        switch (lowValue) {
            case '2' -> lowCardName = "2";
            case '3' -> lowCardName = "3";
            case '4' -> lowCardName = "4";
            case '5' -> lowCardName = "5";
            case '6' -> lowCardName = "6";
            case '7' -> lowCardName = "7";
            case '8' -> lowCardName = "8";
            case '9' -> lowCardName = "9";
            case 'T' -> lowCardName = "10";
            case 'J' -> lowCardName = "Jack";
            case 'Q' -> lowCardName = "Queen";
            case 'K' -> lowCardName = "King";
            case 'A' -> lowCardName = "Ace";
        }
        return lowCardName;
    }

    /**
     * Gives hand a string representing its rank
     *
     * @return String representation of rank.
     */
    public String rankToString() {
        switch (this.rankNumber) {
            case 0 -> rankString = "High Card " + highCardName;
            case 1 -> rankString = "Pair of " + highCardName + "'s";
            case 2 -> rankString = "Two pair with high value: " + highCardName;
            case 3 -> rankString = "Three of a kind  with value:" + highCardName;
            case 4 -> rankString = "Straight with high value: " + highCardName;
            case 5 -> rankString = "Flush with high value: " + highCardName;
            case 6 -> rankString = "Full House: " + highCardName + " over " + lowCardName;
            case 7 -> rankString = "Four of a kind with high value: " + highCardName;
            case 8 -> rankString = "Straight Flush with high value: " + highCardName;
        }

        return rankString;
    }

    /**
     * Sets high value in case of tie breakers.
     *
     * @param inVal value to set next high value to.
     */
    public void setHighValue(char inVal) {
        this.highValue = inVal;
        this.highValueString();
    }


}
