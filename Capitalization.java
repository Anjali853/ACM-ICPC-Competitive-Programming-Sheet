import java.util.Scanner;

public class Capitalization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char firstChar = str.charAt(0);
        char capitalizedChar = Character.toUpperCase(firstChar);
        String restOfString = str.substring(1);
        String capitalizedString = capitalizedChar + restOfString;
        System.out.println(capitalizedString);
    }

}
