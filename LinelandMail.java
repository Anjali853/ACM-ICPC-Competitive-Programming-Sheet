import java.util.Scanner;

public class LinelandMail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {

            long min;
            if (i == 0) {
                min = x[1] - x[0];
            } else if (i == n - 1) {
                min = x[n - 1] - x[n - 2];
            } else {
                min = Math.min(x[i] - x[i - 1], x[i + 1] - x[i]);
            }
            long max = Math.max(x[i] - x[0], x[n - 1] - x[i]);
            System.out.println(min + " " + max);

        }
    }
}