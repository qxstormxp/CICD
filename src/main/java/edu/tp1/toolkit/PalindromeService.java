package edu.tp1.toolkit;

/**
 * Service pour vérifier si une chaîne de caractères est un palindrome.
 * Un palindrome se lit de la même façon de gauche à droite et de droite à gauche,
 * en ignorant la casse, les espaces, la ponctuation et les accents.
 */
public class PalindromeService {
    
    /**
     * Vérifie si une chaîne est un palindrome.
     * 
     * Convention : une chaîne vide, null ou composée uniquement d'espaces/ponctuation
     * est considérée comme un palindrome.
     * 
     * @param text le texte à vérifier
     * @return true si le texte est un palindrome, false sinon
     */
    public static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        
        // Normaliser le texte en utilisant la logique du Slugifier
        // On retire les tirets car on veut juste les caractères alphanumériques
        String normalized = Slugifier.slugify(text).replace("-", "");
        
        // Une chaîne vide après normalisation est considérée comme un palindrome
        if (normalized.isEmpty()) {
            return true;
        }
        
        // Vérifier si la chaîne normalisée est identique à son inverse
        int left = 0;
        int right = normalized.length() - 1;
        
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Méthode d'instance pour permettre une utilisation orientée objet.
     * 
     * @param text le texte à vérifier
     * @return true si le texte est un palindrome, false sinon
     */
    public boolean checkPalindrome(String text) {
        return isPalindrome(text);
    }
}