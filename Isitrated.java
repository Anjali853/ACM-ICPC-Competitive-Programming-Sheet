import java.util.Scanner;

public class Isitrated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int n = sc.nextInt();

        boolean isRated = false;
        boolean wrongOrder = false;
        int previous = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a != b) {
                isRated = true;
            }

            if (a > previous) {
                wrongOrder = true;
            }

            previous = a;
        }
        System.out.println(isRated ? "rated" : (wrongOrder ? "unrated" : "maybe"));

    }

}
