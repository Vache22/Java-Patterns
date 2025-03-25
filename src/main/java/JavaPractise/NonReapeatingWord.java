package JavaPractise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonReapeatingWord {
    public static void main(String[] args) {
        String input = "automation";
        char result = findNonRepeatingCharacter(input);
        System.out.println("First Non-Repeating Character: " +  result);
    }

    public static char findNonRepeatingCharacter(String str) {
        Map<Character, Integer> frequency = new LinkedHashMap<>();

        // Implement logic here
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
    return  '_';
}
}
