import java.util.Scanner;

public class Oath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] > min && a[i] < max) {
                count++;
            }
        }

        System.out.println(count);
    }
}
