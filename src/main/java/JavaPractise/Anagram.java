package JavaPractise;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String firstWord = "listen";
        String secondWord = "silent";

        boolean isAnagramResult = isAnagram(firstWord, secondWord);
        System.out.println(isAnagramResult);
    }

    public static boolean isAnagram(String first, String second) {
        first = first.replaceAll("\\s", "").toLowerCase();
        second = second.replaceAll("\\s", "").toLowerCase();

        if (first.length() != second.length()) {
            return false;
        }

        char[] firstWord = first.toCharArray();
        char[] secondWord = second.toCharArray();
        Arrays.sort(firstWord);
        Arrays.sort(secondWord);
        return Arrays.equals(firstWord, secondWord);
    }
}
