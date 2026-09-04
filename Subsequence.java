import java.util.Scanner;

public class Subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        if (a.equals(b)) {
            System.out.println(-1);
        } else {
            System.out.println(Math.max(a.length(), b.length()));
        }
    }
}