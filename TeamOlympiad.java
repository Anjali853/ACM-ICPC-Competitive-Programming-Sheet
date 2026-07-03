import java.util.ArrayList;
import java.util.Scanner;

public class TeamOlympiad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> Programming = new ArrayList<>();
        ArrayList<Integer> MathList = new ArrayList<>();
        ArrayList<Integer> Sports = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int skill = sc.nextInt();
            if (skill == 1) {
                Programming.add(i);
            } else if (skill == 2) {
                MathList.add(i);
            } else if (skill == 3) {
                Sports.add(i);
            }
        }

        int teamCount = Math.min(Programming.size(), Math.min(MathList.size(), Sports.size()));
        System.out.println(teamCount);
        for (int i = 0; i < teamCount; i++) {
            System.out.println(Programming.get(i) + " " + MathList.get(i) + " " + Sports.get(i));
        }
    }
}