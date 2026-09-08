import java.util.Scanner;

public class Keyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char direction = sc.nextLine().charAt(0);
        String input = sc.nextLine();

        String keyboard = "qwertyuiopasdfghjkl;zxcvbnm,./";
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            int index = keyboard.indexOf(input.charAt(i));

            // yahan direction check karo
            if (direction == 'L') {
                index += 1; // agar direction L hai to index ko 1 se increase karo
            } else if (direction == 'R') {
                index -= 1; // agar direction R hai to index ko 1 se decrease karo
            }

            // answer mein character add karo
            answer.append(keyboard.charAt(index));
        }

        System.out.println(answer);
    }
}