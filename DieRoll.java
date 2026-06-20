import java.util.Scanner;

public class DieRoll {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int w = sc.nextInt();
        int max = Math.max(y, w);

        int count = 0;
        for(int i = max; i<=6; i++){
            count++;
        }
        int total = 6;
        int gcd = gcd(count, total);

        System.out.println((count/gcd)+"/"+(total/gcd));
    }
    
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}
