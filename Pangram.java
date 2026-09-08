import java.util.Scanner;

public class Pangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        boolean[] seen = new boolean[26];
        for (char c : input.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                seen[c - 'a'] = true;
            }
        }
        boolean isPangram = true;
        for (boolean b : seen) {
            if (!b) {
                isPangram = false;
                break;
            }
        }
        System.out.println(isPangram ? "YES" : "NO");
    }
}