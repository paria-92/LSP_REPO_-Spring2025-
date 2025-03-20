package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * The WordProcessor class processes a sentence and extracts the longest words.
 */
public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    /**
     * Constructor to initialize the sentence.
     * @param sentence The input sentence.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Method to find all longest words in the sentence.
     * @return A list of longest words in the order they appear.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords; // Return empty list if input is empty
        }

        String[] words = sentence.split("\\s+"); // Split by whitespace
        int maxLength = 0;

        // Find the longest word length
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        // Collect all words with the max length
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}

/**
 * References:
 * - Java String split() method: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split-java.lang.String-
 * - Java List Documentation: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 * - Finding Maximum Length in Array: https://www.baeldung.com/java-find-max-length-string-array
 * - Handling Empty Strings: https://stackoverflow.com/questions/3215266/trim-string-in-java
 */
