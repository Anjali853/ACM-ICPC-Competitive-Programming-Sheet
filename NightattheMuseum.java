import java.util.Scanner;

public class NightattheMuseum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int current = 0;
       int rotations = 0;

        for (char ch : s.toCharArray()) {
            int target = ch - 'a';

            int diff = Math.abs(target - current);
            rotations += Math.min(diff, 26 - diff);

            current = target;
        }
        System.out.println(rotations);
       


    }
}