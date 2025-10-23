package edu.tp1.toolkit;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Classe utilitaire pour transformer du texte en slug.
 * Un slug est une chaîne normalisée : minuscules, sans accents, 
 * sans ponctuation, espaces remplacés par des tirets.
 */
public class Slugifier {
    
    private static final Pattern MULTIPLE_HYPHENS = Pattern.compile("-+");
    private static final Pattern NON_ASCII_ALPHANUMERIC = Pattern.compile("[^a-z0-9-]");
    
    /**
     * Transforme un texte en slug.
     * 
     * @param text le texte à transformer
     * @return le slug généré, ou une chaîne vide si le texte est null ou vide
     */
    public static String slugify(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        
        // 1. Convertir en minuscules
        String slug = text.toLowerCase();
        
        // 2. Retirer les accents (normalisation Unicode NFD puis suppression des diacritiques)
        slug = Normalizer.normalize(slug, Normalizer.Form.NFD);
        slug = slug.replaceAll("\\p{M}", ""); // Supprime les marques diacritiques
        
        // 3. Remplacer les espaces par des tirets
        slug = slug.replace(" ", "-");
        
        // 4. Supprimer tous les caractères non alphanumériques (sauf les tirets)
        slug = NON_ASCII_ALPHANUMERIC.matcher(slug).replaceAll("");
        
        // 5. Réduire les tirets multiples en un seul
        slug = MULTIPLE_HYPHENS.matcher(slug).replaceAll("-");
        
        // 6. Trim : retirer les tirets en début et fin
        slug = slug.replaceAll("^-+|-+$", "");
        
        return slug;
    }
    
    /**
     * Méthode d'instance pour permettre une utilisation orientée objet.
     * 
     * @param text le texte à transformer
     * @return le slug généré
     */
    public String toSlug(String text) {
        return slugify(text);
    }
}