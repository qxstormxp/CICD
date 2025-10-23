package edu.tp1.toolkit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la classe WordCounter
 */
class WordCounterTest {
    
    @Test
    @DisplayName("Cas null lance IllegalArgumentException")
    void testCountNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordCounter.count(null);
        });
    }
    
    @Test
    @DisplayName("Chaîne vide retourne 0")
    void testCountEmpty() {
        assertEquals(0, WordCounter.count(""));
    }
    
    @Test
    @DisplayName("Chaîne composée uniquement d'espaces retourne 0")
    void testCountOnlySpaces() {
        assertEquals(0, WordCounter.count("   "));
        assertEquals(0, WordCounter.count("     "));
    }
    
    @Test
    @DisplayName("Un seul mot")
    void testCountSingleWord() {
        assertEquals(1, WordCounter.count("hello"));
        assertEquals(1, WordCounter.count("world"));
        assertEquals(1, WordCounter.count("test"));
    }
    
    @Test
    @DisplayName("Deux mots séparés par un espace")
    void testCountTwoWords() {
        assertEquals(2, WordCounter.count("hello world"));
        assertEquals(2, WordCounter.count("java programming"));
    }
    
    @Test
    @DisplayName("Mots séparés par des espaces multiples")
    void testCountMultipleSpaces() {
        assertEquals(2, WordCounter.count("hello   world"));
        assertEquals(3, WordCounter.count("one  two   three"));
        assertEquals(2, WordCounter.count("multiple     spaces"));
    }
    
    @Test
    @DisplayName("Mots séparés par des tabulations")
    void testCountTabSeparators() {
        assertEquals(2, WordCounter.count("hello\tworld"));
        assertEquals(3, WordCounter.count("one\ttwo\tthree"));
    }
    
    @Test
    @DisplayName("Mots séparés par des tirets")
    void testCountHyphenSeparators() {
        assertEquals(2, WordCounter.count("hello-world"));
        assertEquals(2, WordCounter.count("café-crème"));
        assertEquals(3, WordCounter.count("one-two-three"));
    }
    
    @Test
    @DisplayName("Mots séparés par des underscores")
    void testCountUnderscoreSeparators() {
        assertEquals(2, WordCounter.count("hello_world"));
        assertEquals(3, WordCounter.count("one_two_three"));
        assertEquals(2, WordCounter.count("variable_name"));
    }
    
    @Test
    @DisplayName("Mots avec ponctuation retirée")
    void testCountWithPunctuation() {
        assertEquals(3, WordCounter.count("Bonjour, ça va?"));
        assertEquals(2, WordCounter.count("Hello, world!"));
        assertEquals(4, WordCounter.count("Un, deux, trois, quatre."));
        assertEquals(2, WordCounter.count("C'est bien!"));
    }
    
    @Test
    @DisplayName("Mots avec accents préservés")
    void testCountWithAccents() {
        assertEquals(1, WordCounter.count("été"));
        assertEquals(1, WordCounter.count("café"));
        assertEquals(2, WordCounter.count("été automne"));
        assertEquals(3, WordCounter.count("français espagnol português"));
    }
    
    @Test
    @DisplayName("Combinaison de séparateurs")
    void testCountMixedSeparators() {
        assertEquals(4, WordCounter.count("hello world-test_example"));
        assertEquals(5, WordCounter.count("one two-three_four five"));
        assertEquals(4, WordCounter.count("a-b c_d"));
    }
    
    @Test
    @DisplayName("Espaces en début et fin")
    void testCountLeadingTrailingSpaces() {
        assertEquals(2, WordCounter.count("  hello world  "));
        assertEquals(1, WordCounter.count("   test   "));
    }
    
    @Test
    @DisplayName("Séparateurs multiples consécutifs")
    void testCountMultipleSeparators() {
        assertEquals(2, WordCounter.count("hello---world"));
        assertEquals(2, WordCounter.count("one___two"));
        assertEquals(3, WordCounter.count("a--b   c"));
    }
    
    @Test
    @DisplayName("Ponctuation en début et fin")
    void testCountPunctuationAtEnds() {
        assertEquals(1, WordCounter.count("!hello!"));
        assertEquals(2, WordCounter.count("?hello world?"));
        assertEquals(1, WordCounter.count("...test..."));
    }
    
    @Test
    @DisplayName("Chaîne composée uniquement de séparateurs")
    void testCountOnlySeparators() {
        assertEquals(0, WordCounter.count("---"));
        assertEquals(0, WordCounter.count("___"));
        assertEquals(0, WordCounter.count("- _ -"));
    }
    
    @Test
    @DisplayName("Chaîne composée uniquement de ponctuation")
    void testCountOnlyPunctuation() {
        assertEquals(0, WordCounter.count("!!!"));
        assertEquals(0, WordCounter.count("???"));
        assertEquals(0, WordCounter.count("..."));
    }
    
    @Test
    @DisplayName("Mots avec chiffres")
    void testCountWithNumbers() {
        assertEquals(2, WordCounter.count("test 123"));
        assertEquals(3, WordCounter.count("java 8 programming"));
        assertEquals(1, WordCounter.count("2024"));
    }
    
    @Test
    @DisplayName("Cas réels complexes")
    void testCountComplexCases() {
        assertEquals(5, WordCounter.count("Le café-crème coûte 3,50€"));
        assertEquals(5, WordCounter.count("C'est l'été, il fait beau!"));
        assertEquals(7, WordCounter.count("one-two three_four five six-seven"));
    }
    
    @Test
    @DisplayName("Méthode d'instance countWords")
    void testCountWordsInstance() {
        WordCounter counter = new WordCounter();
        assertEquals(2, counter.countWords("hello world"));
        assertEquals(3, counter.countWords("one-two-three"));
    }
    
    @Test
    @DisplayName("Message d'erreur pour null")
    void testNullExceptionMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            WordCounter.count(null);
        });
        assertEquals("Le texte ne peut pas être null", exception.getMessage());
    }
    
    @Test
    @DisplayName("Guillemets et apostrophes")
    void testCountQuotes() {
        assertEquals(3, WordCounter.count("\"hello\" 'world' test"));
        assertEquals(2, WordCounter.count("l'école française"));
    }
}