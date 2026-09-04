import java.util.Scanner;

public class Snacktower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int expected = n;
        boolean[] present = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            present[a[i]] = true;
            while (present[expected]) {
                System.out.print(expected + " ");
                expected--;
            }
            System.out.println();

        }

    }
}