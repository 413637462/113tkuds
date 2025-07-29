import java.util.*;
public class F07_AnagramPalindrome {
    public static boolean canFormPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                freq[c - 'a']++;
            }
        }
        
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(canFormPalindrome(input) ? "Possible" : "Impossible");
    }
}
