// Computes the scrabble score for a given word

package com.challenges;

public class Main {

    public static void main(String[] args) {
        Word word = new Word("street");
        int points = word.score();
        System.out.printf("You scored %d point(s) for %s.", points, word);
    }
}
