import java.util.HashSet;
import java.util.Scanner;

public class AntonandLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i <s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                set.add(ch);
            }

        }
        System.out.println(set.size());

    }
    
}
