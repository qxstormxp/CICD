package edu.tp1.toolkit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la classe PalindromeService
 */
class PalindromeServiceTest {
    
    @Test
    @DisplayName("Cas null retourne true (convention)")
    void testIsPalindromeNull() {
        assertTrue(PalindromeService.isPalindrome(null));
    }
    
    @Test
    @DisplayName("Chaîne vide retourne true (convention)")
    void testIsPalindromeEmpty() {
        assertTrue(PalindromeService.isPalindrome(""));
    }
    
    @Test
    @DisplayName("Chaîne composée uniquement d'espaces retourne true")
    void testIsPalindromeOnlySpaces() {
        assertTrue(PalindromeService.isPalindrome("   "));
        assertTrue(PalindromeService.isPalindrome("     "));
    }
    
    @Test
    @DisplayName("Chaîne composée uniquement de ponctuation retourne true")
    void testIsPalindromeOnlyPunctuation() {
        assertTrue(PalindromeService.isPalindrome("!!!"));
        assertTrue(PalindromeService.isPalindrome("..."));
        assertTrue(PalindromeService.isPalindrome("???"));
    }
    
    @Test
    @DisplayName("Palindromes simples en minuscules")
    void testIsPalindromeSimple() {
        assertTrue(PalindromeService.isPalindrome("radar"));
        assertTrue(PalindromeService.isPalindrome("kayak"));
        assertTrue(PalindromeService.isPalindrome("level"));
        assertTrue(PalindromeService.isPalindrome("noon"));
    }
    
    @Test
    @DisplayName("Un seul caractère est un palindrome")
    void testIsPalindromeSingleChar() {
        assertTrue(PalindromeService.isPalindrome("a"));
        assertTrue(PalindromeService.isPalindrome("Z"));
    }
    
    @Test
    @DisplayName("Palindromes ignorant la casse")
    void testIsPalindromeCaseInsensitive() {
        assertTrue(PalindromeService.isPalindrome("Radar"));
        assertTrue(PalindromeService.isPalindrome("RaDaR"));
        assertTrue(PalindromeService.isPalindrome("KAYAK"));
    }
    
    @Test
    @DisplayName("Palindromes avec espaces")
    void testIsPalindromeWithSpaces() {
        assertTrue(PalindromeService.isPalindrome("a man a plan a canal panama"));
        assertTrue(PalindromeService.isPalindrome("was it a car or a cat i saw"));
        assertTrue(PalindromeService.isPalindrome("no lemon no melon"));
    }
    
    @Test
    @DisplayName("Palindromes avec ponctuation")
    void testIsPalindromeWithPunctuation() {
        assertTrue(PalindromeService.isPalindrome("A man, a plan, a canal: Panama!"));
        assertTrue(PalindromeService.isPalindrome("Madam, I'm Adam"));
        assertTrue(PalindromeService.isPalindrome("Was it a car or a cat I saw?"));
    }
    
    @Test
    @DisplayName("Palindromes avec accents")
    void testIsPalindromeWithAccents() {
        assertTrue(PalindromeService.isPalindrome("Été"));
        assertTrue(PalindromeService.isPalindrome("ete"));
    }
    
    @Test
    @DisplayName("Palindromes français complexes")
    void testIsPalindromeFrench() {
        assertTrue(PalindromeService.isPalindrome("Ésope reste ici et se repose"));
        assertTrue(PalindromeService.isPalindrome("Engage le jeu que je le gagne"));
        assertTrue(PalindromeService.isPalindrome("La mariée ira mal"));
    }
    
    @Test
    @DisplayName("Non-palindromes simples")
    void testIsNotPalindrome() {
        assertFalse(PalindromeService.isPalindrome("hello"));
        assertFalse(PalindromeService.isPalindrome("world"));
        assertFalse(PalindromeService.isPalindrome("java"));
        assertFalse(PalindromeService.isPalindrome("test"));
    }
    
    @Test
    @DisplayName("Non-palindromes avec espaces")
    void testIsNotPalindromeWithSpaces() {
        assertFalse(PalindromeService.isPalindrome("hello world"));
        assertFalse(PalindromeService.isPalindrome("this is not a palindrome"));
    }
    
    @Test
    @DisplayName("Presque palindromes (un caractère de différence)")
    void testAlmostPalindrome() {
        assertFalse(PalindromeService.isPalindrome("radax"));
        assertFalse(PalindromeService.isPalindrome("kayac"));
    }
    
    @Test
    @DisplayName("Palindromes avec chiffres")
    void testIsPalindromeWithNumbers() {
        assertTrue(PalindromeService.isPalindrome("12321"));
        assertTrue(PalindromeService.isPalindrome("1 2 3 2 1"));
        assertFalse(PalindromeService.isPalindrome("12345"));
    }
    
    @Test
    @DisplayName("Méthode d'instance checkPalindrome")
    void testCheckPalindromeInstance() {
        PalindromeService service = new PalindromeService();
        assertTrue(service.checkPalindrome("radar"));
        assertFalse(service.checkPalindrome("hello"));
    }
    
    @Test
    @DisplayName("Cas limites avec caractères spéciaux")
    void testIsPalindromeSpecialCases() {
        assertTrue(PalindromeService.isPalindrome("A-B-A"));
        assertTrue(PalindromeService.isPalindrome("!@#@!"));
        assertTrue(PalindromeService.isPalindrome("1_2_1"));
    }
    
    @Test
    @DisplayName("Palindromes longs")
    void testLongPalindromes() {
        assertTrue(PalindromeService.isPalindrome("abcdefedcba"));
        assertTrue(PalindromeService.isPalindrome("12345678987654321"));
    }
}