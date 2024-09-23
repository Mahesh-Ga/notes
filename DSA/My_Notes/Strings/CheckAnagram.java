public class CheckAnagram {
    public static void main(String[] args) {
        String s = "aab";
        String s1 = "bab";

        int count = 0;
        if(s.length() != s1.length()) {
            System.out.println("Not a Anagram");
        } else {
            for(int i=0;i<s.length();i++) {
                for(int j=0;j<s1.length();j++) {
                    
                    if(s.charAt(i) == s1.charAt(j)) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(s1);
        if(count == s.length()) {
            System.out.println("Anagram");
        } else {
            System.out.println("NOt an anagram");
        }

    } 
}
