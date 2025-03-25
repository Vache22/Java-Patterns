package JavaPractise;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String sentence = "apple banana apple orange banana apple";

        // Call function and print result
        Map<String, Integer> wordCount = countWordFrequency(sentence);
        System.out.println(formatOutput(wordCount));
    }

    public static String formatOutput(Map<String, Integer> wordCount) {
        // Implement logic here
        return wordCount.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .map(e -> e.getKey() + " = " + e.getValue())
                .collect(Collectors.joining(", "));
    }

    public static Map<String, Integer> countWordFrequency(String sentence) {
        // Implement logic here
        String[] words = sentence.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
}
