import java.util.Scanner;

public class AcCepted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if (s.charAt(0) != 'A') {
            System.out.println("WA");
            return;
        }

        int count = 0;
        for (int i = 2; i <= s.length() - 2; i++) {
            if (s.charAt(i) == 'C') {
                count++;
            }
        }

        if (count != 1) {
            System.out.println("WA");
            return;
        }
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isUpperCase(ch)) {
                if (ch != 'C') {
                    System.out.println("WA");
                    return;
                }
            }
        }

        System.out.println("AC");
    }
}