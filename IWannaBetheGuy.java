import java.util.Scanner;

public class IWannaBetheGuy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] levels = new boolean[n + 1];
        int p = sc.nextInt();
        for (int i = 0; i < p; i++) {
            levels[sc.nextInt()] = true;
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            levels[sc.nextInt()] = true;
        }
        boolean allLevelsComplete = true;
        for (int i = 1; i <= n; i++) {
            if (!levels[i]) {
                allLevelsComplete = false;
                break;
            }
        }
        System.out.println(allLevelsComplete ? "I become the guy." : "Oh, my keyboard!");
    }

}
