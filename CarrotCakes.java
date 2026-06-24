import java.util.Scanner;

public class CarrotCakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();

        int batches = (n + k - 1) / k;
        int singleTime = batches * t;
       for(int time = 1; time < singleTime; time++) {

    int cakes = (time / t) * k;   // Oven 1

    if(time > d) {
        cakes += ((time - d) / t) * k;   // Oven 2
    }

    if(cakes >= n) {
        System.out.println("YES");
        return;
    }
}

System.out.println("NO");

    }
}    