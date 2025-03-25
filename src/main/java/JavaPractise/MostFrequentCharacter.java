package JavaPractise;

import java.util.*;
import java.util.stream.Collectors;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        String input = "hello world";
        input = input.replaceAll("\\s", "");

        // Call function and print result
        Map<Character, Integer> charCount = countCharacterFrequency(input);

        // Find and print the most frequent character
        findMostFrequentChar(charCount);
    }

    public static Map<Character, Integer> countCharacterFrequency(String input) {
        // Implement logic here
        Map<Character, Integer> charCount = new HashMap<>();
        for(char c : input.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }

    public static void findMostFrequentChar(Map<Character, Integer> charCount) {
        // Implement logic here
        charCount.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .limit(1)
                .forEach(e -> System.out.println("Most frequent character: " + e.getKey() + " (occurs " + e.getValue() + " times)"));

    }
}
