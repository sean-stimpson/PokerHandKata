Kata Source: https://codingdojo.org/kata/PokerHands/

PokerHand 

This is an application that builds and evaluates five-card poker hands. It places two hands against one another 
and prints out the winner. 
PokerHand can take in input from the user via console, manual array/string entry, or through a txt file. All of this 
is done through the PokerHandDriver class. In this class you can un-comment whichever option you choose to run. 
The project is centralized through the PokerHand class. This class handles the creation of the hand and storing its
values. There are separate objects it calls on in order to handle a few of these tasks. There are HandCreator and
HandRanker classes that handle the creation and ranking of hands. The Card class creates Card objects for the PokerHand
to store. Finally, the HandCompare object compares two hands and declares the winner. 

Design

I chose to use ArrayLists for storing cards due to the amount of manipulation needed throughout the program. ArrayLists
also allowed for good readability and ease of manipulating the Cards inside it. I chose to separate the classes as much
as possible to also allow easy understanding of the program. Each class revolves around one task. Some of the classes 
could be included as inner classes of the PokerHand object, but due to the length and complex nature of these classes I  
chose to keep them as separate objects. I stored and retrieved card values as ints or chars as much as possible for 
performance management and ease of comparing.

 For testing, I tended to use more than one assert per method. Due to some of the comparing, I wanted my testing to be 
as exhaustive as possible to ensure the cards were being compared correctly. That being said, the asserts do all test 
the same concepts in each method. 

How It Works

The code begins by passing a string or a string array to the poker hand class. From here the data is passed into the 
HandCreator. The HandCreator then processes the String or array turning the data into cards and returns an ArrayList of
cards. Back in the PokerHand Object, this list is now sorted and sent to the HandRanker. The ranker evaluates what 
kind of hand this list is (ie. Flush) and returns an int value for the PokerHand object to store as its rank.  The 
ranker also provides the PokerHand object with a string representing its rank. Once two hands are created, whichever 
game class is called uses the HandCompare class to compare the two classes and print out the winning hand. 

How to Use

All methods of input are through the PokerHandDriver class. From here you can uncomment whichever method of input you would
like to use. By default, the file method of input is uncommented. This calls on the ExampleCards.txt file that is 
in the directory. This file can be modified with added input, but the format of the input must stay the same. You can
use manual input by changing any of the provided array values in the driver class and uncommenting that section. 
Uncommenting the user input block creates a loop in which you can enter values for the hands and play them against one
another. 
