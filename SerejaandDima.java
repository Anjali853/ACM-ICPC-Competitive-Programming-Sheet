import java.util.Scanner;

public class SerejaandDima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int left = 0;
        int right = n-1;
        int sereja =0;
        int dima =0;
        int turn = 0;
        while (left <= right) {
            int picked;
            if(arr[left] > arr[right]){
                picked = arr[left];
                left++;
 
            }else{
                picked = arr[right];
                right--;
            }
            if(turn == 0){
                sereja += picked;
                turn = 1;
            }else{
                dima += picked;
                turn = 0;
            }
        }
        System.out.println(sereja + " " + dima);
    }

    
}
