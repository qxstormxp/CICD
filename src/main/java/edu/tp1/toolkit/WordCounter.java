package edu.tp1.toolkit;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Service pour compter les mots dans une chaîne de caractères.
 * Les séparateurs de mots sont : espaces, tabulations, tirets (-) et underscores (_).
 * La ponctuation classique est retirée et les accents sont préservés.
 */
public class WordCounter {
    
    private static final Pattern PUNCTUATION = Pattern.compile("[.,;:!?'\"()\\[\\]{}…]");
    private static final Pattern WORD_SEPARATORS = Pattern.compile("[ \\t\\-_]+");
    
    /**
    * Compte le nombre de mots dans un texte.
    * 
    * Séparateurs : espaces, tabulations, tirets (-) et underscores (_)
    * La ponctuation classique est retirée avant le comptage.
    * Les accents sont considérés comme des lettres valides.
    * 
    * @param text le texte à analyser
    * @return le nombre de mots
    * @throws IllegalArgumentException si le texte est null
    */
    public static int count(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Le texte ne peut pas être null");
        }
        
        if (text.isEmpty()) {
            return 0;
        }
        
        // 1. Retirer la ponctuation classique
        String cleaned = PUNCTUATION.matcher(text).replaceAll("");
        
        // 2. Diviser selon les séparateurs (espaces, tabs, tirets, underscores)
        String[] words = WORD_SEPARATORS.split(cleaned);
        
        // 3. Compter uniquement les mots non vides
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Méthode d'instance pour permettre une utilisation orientée objet.
     * 
     * @param text le texte à analyser
     * @return le nombre de mots
     * @throws IllegalArgumentException si le texte est null
     */
    public int countWords(String text) {
        return count(text);
    }
}
