package JavaPractise;

public class Palindrome2 {
    public static void main(String[] args) {
        String word3 = "babad";
        System.out.println(longestPalindrome(word3)); // Expected: "bab" or "aba"
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes (single-character center)
            String oddPalindrome = expandAroundCenter(s, i, i);

            // Even-length palindromes (two-character center)
            String evenPalindrome = expandAroundCenter(s, i, i + 1);

            // Keep the longest palindrome found
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }
        return longest;
    }

    // Expands from center and returns the longest palindrome
    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right); // Extract the palindrome
    }
}
