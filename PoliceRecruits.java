import java.util.Scanner;

public class PoliceRecruits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       int police = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x > 0) {
                police += x;
            } else {
                if (police > 0) {
                    police--;
                } else {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    
}
