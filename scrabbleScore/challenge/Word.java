// Computes the scrabble score for a given word

package challenge;

import java.util.*;

public class Word {
    private static String Word;
    private static Map<List<Character>, Integer> POINTS_PER_LETTER = new HashMap<>();

    public Word(String wordString) {
        this.Word = wordString;
        POINTS_PER_LETTER.put(Arrays.asList('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'), 1);
        POINTS_PER_LETTER.put(Arrays.asList('D','G'), 2);
        POINTS_PER_LETTER.put(Arrays.asList('B', 'C', 'M', 'P'), 3);
        POINTS_PER_LETTER.put(Arrays.asList('F', 'H', 'V', 'W', 'Y'), 4);
        POINTS_PER_LETTER.put(Arrays.asList('K'), 5);
        POINTS_PER_LETTER.put(Arrays.asList('J', 'X'), 8);
        POINTS_PER_LETTER.put(Arrays.asList('Q', 'Z'), 10);
    }

    @Override
    public String toString() {
        return this.Word;
    }

    public int score() {
        int totalWordPoints = 0;
        try {
            if (this.Word.matches("[A-Za-z]+")) {
                char[] characters = this.Word.toUpperCase().toCharArray();
                for (char character : characters) {
                    for (Map.Entry<List<Character>, Integer> entry : POINTS_PER_LETTER.entrySet()) {
                        if (entry.getKey().contains(character)) {
                            totalWordPoints += entry.getValue();
                        }
                    }
                }
            }
        } catch (NullPointerException npe){
            System.out.println("No word to score.");
            return totalWordPoints;
        }
        return totalWordPoints;
    }
}
