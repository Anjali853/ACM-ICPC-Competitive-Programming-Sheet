import java.util.Scanner;

public class Morelight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            long n = sc.nextLong();

            if (n == 0) {
                break;
            }

            long root = (long) Math.sqrt(n);

            if (root * root == n) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
