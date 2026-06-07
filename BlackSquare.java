import java.util.*;

public class BlackSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[5];

        for (int i = 1; i <= 4; i++) {
            a[i] = sc.nextInt();
        }

        String s = sc.next();

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            sum += a[digit];
        }

        System.out.println(sum);
    }
}