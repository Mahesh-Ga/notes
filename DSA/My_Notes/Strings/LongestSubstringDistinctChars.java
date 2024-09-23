import java.util.HashMap;

public class LongestSubstringDistinctChars {
    public static String findLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        int start = 0;  // Start of the current substring
        int maxStart = 0;  // Start of the longest substring
        int maxLength = 0;  // Length of the longest substring

        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (charIndexMap.containsKey(currentChar)) {
                // If the current character is already in the substring, update the start index
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }

            charIndexMap.put(currentChar, i);

            // Calculate the length of the current substring
            int currentLength = i - start + 1;

            // If the current substring is longer than the longest found so far, update maxStart and maxLength
            if (currentLength > maxLength) {
                maxStart = start;
                maxLength = currentLength;
            }
        }

        // Extract the longest substring
        return s.substring(maxStart, maxStart + maxLength);
    }

    public static void main(String[] args) {
        String input = "abcabcbb";  // Replace with your input string
        String longestSubstring = findLongestSubstring(input);
        System.out.println("Longest substring with distinct characters: " + longestSubstring);
    }
}
