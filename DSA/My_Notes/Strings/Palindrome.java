public class Palindrome {
    public static void main(String[] args) {
        String s = "AJja";

        // Approach 1:
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        String revS = str.toString();

        if (revS.equals(s)) { // case Insensitive : revS.equalsIgnoreCase(s)
            System.out.println("Palindrome");
        } else
            System.out.println("Not a Palindrome");

        // Approach 2:
        int start = 0, end = s.length() - 1, flag = 0;

        while (start < end) {
            if (s.charAt(start) - s.charAt(end) != 0) {
                if (Math.abs(s.charAt(start) - s.charAt(end)) != 32) { // case Insensitive
                    flag = 1;
                    break;
                }
            }
            start++;
            end--;

        }
        if (flag == 0)
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");

    }
}