import java.util.Scanner;

public class ColorfulStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        int count = 0;
        int j = 0;
        for(int i =0; i<t.length(); i++){
            if(t.charAt(i) == s.charAt(j)){
                count++;
                j++;
            }
        }
        System.out.println(j+1);
    }
}
