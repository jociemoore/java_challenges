package challenge;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class WordTest {

    @Test
    public void shouldReturnScoreForStreet() throws Exception {
        Word word = new Word("street");

        int points = word.score();

        assertEquals(6, points);
    }

    @Test
    public void shouldReturnScoreOfZeroForEmptyWord() throws Exception {
        Word word = new Word("");

        int points = word.score();

        assertEquals(0, points);

    }

    @Test
    public void shouldReturnScoreOfZeroForWhitespace() throws Exception {
        Word word = new Word(" \t\n");

        int points = word.score();

        assertEquals(0, points);
    }

    @Test
    public void shouldReturnScoreOfZeroForWordWithNumbersAfter() throws Exception {
        Word word = new Word("street123");

        int points = word.score();

        assertEquals(0, points);
    }

    @Test
    public void shouldReturnScoreOfZeroForWordWithNumbersBefore() throws Exception {
        Word word = new Word("123street");

        int points = word.score();

        assertEquals(0, points);
    }

    @Test
    public void shouldNotAllowNoWord() throws Exception {
        Word word = new Word(null);
        ExpectedException.none().expect(NullPointerException.class);
        ExpectedException.none().expectMessage("No word to score.");

        int points = word.score();

        assertEquals(0, points);
    }


    @Test
    public void shouldReturnScoreOfOneForA() throws Exception {
        Word word = new Word("a");

        int points = word.score();

        assertEquals(1, points);
    }


    @Test
    public void shouldReturnFourForF() throws Exception {
        Word word = new Word("f");

        int points = word.score();

        assertEquals(4, points);
    }


    @Test
    public void shouldReturnTwentyTwoForQuirky() throws Exception {
        Word word = new Word("quirky");

        int points = word.score();

        assertEquals(22, points);
    }

    @Test
    public void shouldReturnFortyOneForUppercaseJibberish() throws Exception {
        Word word = new Word("OXYPHENBUTAZONE");

        int points = word.score();

        assertEquals(41, points);
    }

    @Test
    public void shouldReturnThirteenForAlacrity() throws Exception {
        Word word = new Word("alacrity");

        int points = word.score();

        assertEquals(13, points);
    }
}