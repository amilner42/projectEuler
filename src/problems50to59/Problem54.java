package problems50to59;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

// Question -----------------------------------------------------------------------------------------------------------------------
//
//  Question is very long, refer to link:
//      https://projecteuler.net/problem=54
//
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem54 {

    public static void main(String[] args) throws IOException {

        // Read the poker hands from a file
        String[][] pokerHands = new String[1000][10];
        BufferedReader inputStream = new BufferedReader(new FileReader("Problem54InputFile"));
        int player1Wins = 0;

        try {
            int index = 0;
            String line;
            while ((line = inputStream.readLine()) != null) {
                pokerHands[index] = line.split(" ");
                index++;
            }
        } finally {
            // This finally block making sure that the inputStream closes no matter what
            inputStream.close();
        }

        // Go through 1000 thousand hands and record every time Player 1 has a better hand than Player 2
        for(int i = 0; i < pokerHands.length; i++) {
            Hand player1Hand = new Hand(pokerHands[i][0], pokerHands[i][1], pokerHands[i][2], pokerHands[i][3], pokerHands[i][4]);
            Hand player2Hand = new Hand(pokerHands[i][5], pokerHands[i][6], pokerHands[i][7], pokerHands[i][8], pokerHands[i][9]);
            if (player1Hand.better(player2Hand)) {
                player1Wins++;
            }
        }
        System.out.println(player1Wins);
    }
}

class Hand {

    // Level: Quads vs Royal Flush (higher is better)
    // SubLevel: Quads 9s vs Quads 5s (higher is better)
    // SubSubLevel: Two Pair is the only case where this is important, lower pair is subSubLevel
    // TieBreaker: Value of cards in a sorted array, for when high card is important
    public int level , sublevel , subsublevel;
    public int[] tieBreaker;

    public Hand(String c1, String c2, String c3, String c4, String c5) {
        tieBreaker = new int[]{getCardValue(c1) , getCardValue(c2) , getCardValue(c3) , getCardValue(c4) , getCardValue(c5)};
        Arrays.sort(tieBreaker);

        // Figure out the hands level/subLevel/subSubLevel
        if(isRoyalFlush(c1 , c2 , c3 , c4 , c5)) {
            level = 10;
        } else if(isStraightFlush(c1 , c2 , c3 , c4 , c5)) {
            level = 9;
            sublevel = tieBreaker[4];
        } else if(isFourOfAKind(c1 , c2 , c3 , c4 , c5)) {
            level = 8;
            sublevel = tieBreaker[3];
        } else if(isFullHouse(c1 , c2 , c3 , c4 , c5)) {
            level = 7;
            sublevel = tieBreaker[2];
        } else if(isFlush(c1, c2, c3, c4, c5)) {
            level = 6;
        } else if(isStraight(c1 , c2 , c3 , c4 , c5)) {
            level = 5;
            sublevel = tieBreaker[4];
        } else if(isThreeOfAKind(c1 , c2 , c3 , c4 , c5)) {
            level = 4;
            sublevel = tieBreaker[2];
        } else if(isTwoPairs(c1 , c2 , c3 , c4 , c5)) {
            level = 3;
            int[] multiplicity = new int[15];
            for(int i = 0; i < tieBreaker.length; i++) {
                multiplicity[tieBreaker[i]]++;
            }
            for(int i = 0; i < multiplicity.length; i++) {
                if(multiplicity[i] == 2 && subsublevel == 0) {
                    subsublevel = i;
                } else if(multiplicity[i] == 2) {
                    sublevel = i;
                }
            }
        } else if(isOnePair(c1 , c2 , c3 , c4 , c5)) {
            level = 2;
            if(tieBreaker[4] == tieBreaker[3]) {
                sublevel = tieBreaker[4];
            } else if(tieBreaker[3] == tieBreaker[2]) {
                sublevel = tieBreaker[3];
            } else if(tieBreaker[2] == tieBreaker[1]) {
                sublevel = tieBreaker[2];
            } else {
                sublevel = tieBreaker[1];
            }
        } else {
            level = 1;
        }

    }

    // Returns true if this.hand is better than otherHand.hand
    public boolean better(Hand otherHand) {
        return (this.level > otherHand.level) ||
                (this.level == otherHand.level && this.sublevel > otherHand.sublevel) ||
                (this.level == otherHand.level && this.sublevel == otherHand.sublevel && this.subsublevel > otherHand.subsublevel) ||
                (this.level == otherHand.level && this.sublevel == otherHand.sublevel && this.subsublevel == otherHand.subsublevel && this.betterBreaker(otherHand.tieBreaker));
    }

    private boolean betterBreaker(int[] tieBreaker) {
        for(int i = 4; i >= 0; i--) {
            if(this.tieBreaker[i] > tieBreaker[i]) {
                return true;
            }
            if(this.tieBreaker[i] < tieBreaker[i]) {
                return false;
            }
        }
        // should never get here, no equal hands in this problem ('always a winner')
        return true;
    }

    private boolean isRoyalFlush(String c1, String c2, String c3, String c4, String c5) {
        return isFlush(c1 , c2 , c3 , c4 , c5) && isStraight(c1 , c2 , c3 , c4 , c5) && hasAce(c1 , c2 , c3 , c4 , c5);
    }

    private boolean isStraightFlush(String c1, String c2, String c3, String c4, String c5) {
        return isFlush(c1, c2, c3, c4, c5) && isStraight(c1 , c2 , c3 , c4 , c5);
    }

    private boolean isFourOfAKind(String c1, String c2, String c3, String c4, String c5) {
        int[] multiplicity = new int[15];
        multiplicity[getCardValue(c1)]++;
        multiplicity[getCardValue(c2)]++;
        multiplicity[getCardValue(c3)]++;
        multiplicity[getCardValue(c4)]++;
        multiplicity[getCardValue(c5)]++;

        for(int i = 0; i < multiplicity.length; i++) {
            if(multiplicity[i] == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean isFullHouse(String c1, String c2, String c3, String c4, String c5) {
        int[] multiplicity = new int[15];
        boolean hasTwo = false , hasThree = false;

        multiplicity[getCardValue(c1)]++;
        multiplicity[getCardValue(c2)]++;
        multiplicity[getCardValue(c3)]++;
        multiplicity[getCardValue(c4)]++;
        multiplicity[getCardValue(c5)]++;

        for(int i = 0; i < multiplicity.length; i++) {
            if(multiplicity[i] == 2) {
                hasTwo = true;
            }
            if(multiplicity[i] == 3) {
                hasThree = true;
            }
        }
        return hasThree && hasTwo;
    }

    private boolean isFlush(String c1, String c2, String c3, String c4, String c5) {
        HashSet<Character> kinds = new HashSet<>();
        return c1.charAt(1) == c2.charAt(1) && c2.charAt(1) == c3.charAt(1) && c3.charAt(1) == c4.charAt(1) && c4.charAt(1) == c5.charAt(1);
    }

    private boolean isStraight(String c1, String c2, String c3, String c4, String c5) {
        int currentInARow = 0;
        int[] multiplicity = new int[15];

        multiplicity[getCardValue(c1)]++;
        multiplicity[getCardValue(c2)]++;
        multiplicity[getCardValue(c3)]++;
        multiplicity[getCardValue(c4)]++;
        multiplicity[getCardValue(c5)]++;

        for(int i = 0; i < multiplicity.length; i++) {
            if (multiplicity[i] != 0) {
                currentInARow++;
                if (currentInARow == 5) {
                    return true;
                }
            } else {
                currentInARow = 0;
            }
        }
        return false;
    }

    private boolean isThreeOfAKind(String c1, String c2, String c3, String c4, String c5) {
        int[] multiplicity = new int[15];
        int hasOne = 0 , hasThree = 0;

        multiplicity[getCardValue(c1)]++;
        multiplicity[getCardValue(c2)]++;
        multiplicity[getCardValue(c3)]++;
        multiplicity[getCardValue(c4)]++;
        multiplicity[getCardValue(c5)]++;

        for(int i = 0; i < multiplicity.length; i++) {
            if(multiplicity[i] == 1) {
                hasOne++;
            }
            if(multiplicity[i] == 3) {
                hasThree++;
            }
        }

        return hasOne == 2 && hasThree == 1;
    }

    private boolean isTwoPairs(String c1, String c2, String c3, String c4, String c5) {
        int[] multiplicity = new int[15];
        int hasTwo = 0;

        multiplicity[getCardValue(c1)]++;
        multiplicity[getCardValue(c2)]++;
        multiplicity[getCardValue(c3)]++;
        multiplicity[getCardValue(c4)]++;
        multiplicity[getCardValue(c5)]++;

        for(int i = 0; i < multiplicity.length; i++) {
            if(multiplicity[i] == 2) {
                hasTwo++;
            }
        }

        return hasTwo == 2;
    }

    private boolean isOnePair(String c1, String c2, String c3, String c4, String c5) {
        int[] multiplicity = new int[15];
        int hasTwo = 0 , hasOne = 0;

        multiplicity[getCardValue(c1)]++;
        multiplicity[getCardValue(c2)]++;
        multiplicity[getCardValue(c3)]++;
        multiplicity[getCardValue(c4)]++;
        multiplicity[getCardValue(c5)]++;

        for(int i = 0; i < multiplicity.length; i++) {
            if(multiplicity[i] == 1) {
                hasOne++;
            }
            if(multiplicity[i] == 2) {
                hasTwo++;
            }
        }
        return hasOne == 3 && hasTwo == 1;
    }

    private boolean hasAce(String c1, String c2, String c3, String c4, String c5) {
        return (getCardValue(c1) == 14) ||
                (getCardValue(c2) == 14) ||
                (getCardValue(c3) == 14) ||
                (getCardValue(c4) == 14) ||
                (getCardValue(c5) == 14);
    }

    private int getCardValue(String c) {
        switch (c.charAt(0)) {
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            case 'T': return 10;
            case 'J': return 11;
            case 'Q': return 12;
            case 'K': return 13;
            case 'A': return 14;
        }
        // Will never get here
        return -1;
    }
}