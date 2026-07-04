import java.util.Scanner;

public class NewPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            char c = (char) ('a' + (i % k));
            System.out.print(c);
        }
    }
}
