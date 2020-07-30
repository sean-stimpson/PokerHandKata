package pokerhand;

import java.util.ArrayList;

/**
 * PokerHand class creates a new poker hand. Contains a ranker and creator.
 */

public class PokerHand {
    //Ranker and Creator to rank/create hands
    private final HandRanker ranker;
    private final HandCreator creator;
    //list of cards for the hand to track
    private ArrayList<Card> hand;
    //Text and int representation of hand rank
    private String rankString;
    private int handRank;
    //int that tracks the highcard of the hand for scoring purposes.
    private int highCardValue;

    /**
     * Constructor creates a PokerHandKata.PokerHand.PokerHand with Hand creator and ranker objects.
     *
     * @param inHand String array to create PokerHand.Card ArrayList
     */
    public PokerHand(String[] inHand) {
        creator = new HandCreator();
        hand = creator.getHand(inHand);
        this.sortHand();
        ranker = new HandRanker(hand);
        handRank = ranker.rankToNumber();
        rankString = ranker.rankToString();
        highCardValue = hand.get(4).getValue();
    }

    /**
     * Constructor to create a PokerHandKata.PokerHand.PokerHand from String input.
     *
     * @param inHand String to create PokerHand.Card ArrayList
     */
    public PokerHand(String inHand) {
        this.creator = new HandCreator();
        hand = creator.getHand(inHand);
        this.sortHand();
        ranker = new HandRanker(hand);
        handRank = ranker.rankToNumber();
        rankString = ranker.rankToString();
        highCardValue = hand.get(4).getValue();
    }

    /**
     * Returns numeric value of a single card
     *
     * @param index Points to card in array
     * @return returns integer value of the pointed to card
     */
    public int getValueInt(int index) {
        return this.hand.get(index).getValue();
    }

    /**
     * Returns rank of hand as int (ie. Full House = 6)
     *
     * @return int signifying rank
     */
    public int getHandRank() {
        return handRank;
    }

    /**
     * Method to set high card value in case of tie Breakers
     *
     * @param index points to card in hand array.
     */
    public void setHighCardValue(int index) {
        this.highCardValue = hand.get(index).getValue();
        ranker.setHighValue(this.hand.get(index).getValueText());
        rankString = ranker.rankToString();
    }

    /**
     * Method to return the hands rank as a string.
     *
     * @return String of rank.
     */
    public String handToString() {
        return rankString;
    }

    /**
     * Sorts array of cards with lowest value first using a selection sort algo.
     */
    public void sortHand() {
        int len = hand.size();
        Card tempCard;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (hand.get(j).getValue() < hand.get(i).getValue()) {
                    tempCard = hand.get(i);
                    hand.set(i, hand.get(j));
                    hand.set(j, tempCard);
                }
            }
        }
    }

    /**
     * Method to return card as a String in original format. (ie. 4 of spades = 4S)
     *
     * @param index points to the card for desired text.
     * @return String of card text.
     */
    public String cardToString(int index) {
        return this.hand.get(index).getCardText();
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    /**
     * Changes PokerHandKata.PokerHand.PokerHand to represent new cards with a String Array.
     *
     * @param inHand array to set new hand to.
     */
    public void setHand(String[] inHand) {
        this.hand = creator.getHand(inHand);
        this.sortHand();
        this.ranker.setRanker(this.hand);
        this.handRank = ranker.rankToNumber();
        this.rankString = ranker.rankToString();
        this.highCardValue = hand.get(4).getValue();
    }

    /**
     * setHand method for String input.
     *
     * @param inHand String to set PokerHand.Card Array
     */
    public void setHand(String inHand) {
        this.hand = creator.getHand(inHand);
        this.sortHand();
        this.ranker.setRanker(this.hand);
        this.handRank = ranker.rankToNumber();
        this.rankString = ranker.rankToString();
        this.highCardValue = hand.get(4).getValue();
    }
}
