package br.dev.kuhn.jackchat.v1.conversation.utilities;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtilities {

    // Method to remove accentuation from a string
    public static String removeAccents(String input) {
        if (input == null) {
            return null;
        }

        // Normalize the string to decompose accented characters
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);

        // Use a regex to remove the accentuated characters
        Pattern pattern = Pattern.compile("\\p{M}");
        return pattern.matcher(normalized).replaceAll("");
    }
}