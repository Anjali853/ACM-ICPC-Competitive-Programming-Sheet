import java.util.Scanner;

public class AcCepted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                if (s.charAt(0) != 'A') {
                    System.out.println("WA");
                    return;
                }
            }
        }
        System.out.println("Accepted");
    }
}