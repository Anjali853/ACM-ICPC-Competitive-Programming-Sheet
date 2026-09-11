import java.util.Scanner;

public class Hierarchy{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int student = 1; student <= k; student++) {
        int w = sc.nextInt();

    for (int j = 0; j < w; j++) {
        int target = sc.nextInt();
        // student wants to be superior of target
        System.out.println(student + " wants to be superior of " + target);
    }
}
System.out.println("Total students: " + n);
int[] parent = new int[n + 1];



    }
}