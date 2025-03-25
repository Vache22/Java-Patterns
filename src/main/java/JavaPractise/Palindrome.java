package JavaPractise;

public class Palindrome {
    public static void main(String[] args) {
        String word = "madam";
        boolean isPalindromeResult = isPalindrome(word);
        //System.out.println(isPalindromeResult);

        String word2 = "racecar";
        String word3 = "babad";
        System.out.println(longestPalindrome(word3));;
    }

    public static boolean isPalindrome(String word) {
        StringBuilder reversedWord = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord.append(word.charAt(i));
        }
        return word.contentEquals(reversedWord);
    }

    public static String longestPalindrome(String word) {
        String longestPalindrome = "";
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                String currentWord = word.substring(i, j);
                if (isPalindrome(currentWord) && currentWord.length() > longestPalindrome.length()) {
                    longestPalindrome = currentWord;
                }
            }
        }
        return longestPalindrome;
    }
}
