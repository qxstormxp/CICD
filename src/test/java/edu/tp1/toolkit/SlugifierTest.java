package edu.tp1.toolkit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la classe Slugifier
 */
class SlugifierTest {
    
    @Test
    @DisplayName("Cas null retourne une chaîne vide")
    void testSlugifyNull() {
        assertEquals("", Slugifier.slugify(null));
    }
    
    @Test
    @DisplayName("Chaîne vide retourne une chaîne vide")
    void testSlugifyEmpty() {
        assertEquals("", Slugifier.slugify(""));
    }
    
    @Test
    @DisplayName("Conversion en minuscules")
    void testSlugifyLowercase() {
        assertEquals("hello", Slugifier.slugify("HELLO"));
        assertEquals("hello-world", Slugifier.slugify("Hello World"));
    }
    
    @Test
    @DisplayName("Suppression des accents")
    void testSlugifyAccents() {
        assertEquals("cafe-au-lait", Slugifier.slugify("Café au lait"));
        assertEquals("ete", Slugifier.slugify("été"));
        assertEquals("noel", Slugifier.slugify("Noël"));
        assertEquals("francais", Slugifier.slugify("Français"));
    }
    
    @Test
    @DisplayName("Remplacement des espaces par des tirets")
    void testSlugifySpaces() {
        assertEquals("hello-world", Slugifier.slugify("hello world"));
        assertEquals("multiple-spaces", Slugifier.slugify("multiple   spaces"));
    }
    
    @Test
    @DisplayName("Suppression de la ponctuation")
    void testSlugifyPunctuation() {
        assertEquals("hello-world", Slugifier.slugify("Hello World!"));
        assertEquals("cest-lete", Slugifier.slugify("C'est l'été!"));
        assertEquals("quest-ce", Slugifier.slugify("Qu'est-ce?"));
        assertEquals("test-123", Slugifier.slugify("Test: 123!"));
    }
    
    @Test
    @DisplayName("Réduction des tirets multiples")
    void testSlugifyMultipleHyphens() {
        assertEquals("hello-world", Slugifier.slugify("hello---world"));
        assertEquals("test", Slugifier.slugify("test------"));
        assertEquals("a-b-c", Slugifier.slugify("a--b---c"));
    }
    
    @Test
    @DisplayName("Trim des tirets en début et fin")
    void testSlugifyTrimHyphens() {
        assertEquals("hello", Slugifier.slugify("-hello-"));
        assertEquals("world", Slugifier.slugify("---world---"));
        assertEquals("test", Slugifier.slugify("--test--"));
    }
    
    @Test
    @DisplayName("Chaîne composée uniquement d'espaces")
    void testSlugifyOnlySpaces() {
        assertEquals("", Slugifier.slugify("   "));
        assertEquals("", Slugifier.slugify("     "));
    }
    
    @Test
    @DisplayName("Chaîne composée uniquement de ponctuation")
    void testSlugifyOnlyPunctuation() {
        assertEquals("", Slugifier.slugify("!!!"));
        assertEquals("", Slugifier.slugify("???!!!"));
        assertEquals("", Slugifier.slugify("..."));
    }
    
    @Test
    @DisplayName("Conservation des chiffres")
    void testSlugifyNumbers() {
        assertEquals("test-123", Slugifier.slugify("test 123"));
        assertEquals("2024-edition", Slugifier.slugify("2024 Edition"));
    }
    
    @Test
    @DisplayName("Cas complexes réels")
    void testSlugifyComplexCases() {
        assertEquals("hello-world", Slugifier.slugify("Hello World!"));
        assertEquals("cafe-au-lait", Slugifier.slugify("Café au lait"));
        assertEquals("cest-lete", Slugifier.slugify("C'est l'été!"));
        assertEquals("lecole-42", Slugifier.slugify("L'école #42"));
        assertEquals("bon-appetit", Slugifier.slugify("Bon appétit!!!"));
    }
    
    @Test
    @DisplayName("Méthode d'instance toSlug")
    void testToSlugInstance() {
        Slugifier slugifier = new Slugifier();
        assertEquals("hello-world", slugifier.toSlug("Hello World!"));
        assertEquals("cafe", slugifier.toSlug("Café"));
    }
    
    @Test
    @DisplayName("Caractères spéciaux et symboles")
    void testSlugifySpecialCharacters() {
        assertEquals("emailtest", Slugifier.slugify("email@test"));
        assertEquals("prix-100", Slugifier.slugify("Prix: 100€"));
        assertEquals("50-de-reduction", Slugifier.slugify("50% de réduction"));
    }
    
    @Test
    @DisplayName("Texte avec tabulations et retours à la ligne")
    void testSlugifyWhitespaceCharacters() {
        assertEquals("helloworld", Slugifier.slugify("hello\tworld"));
        assertEquals("line1line2", Slugifier.slugify("line1\nline2"));
    }
}