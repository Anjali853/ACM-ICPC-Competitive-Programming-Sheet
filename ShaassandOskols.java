import java.util.Scanner;

public class ShaassandOskols {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] birds = new int[n];
        for(int i = 0; i<n; i++){
            birds[i] = sc.nextInt();
        }
        int shots = sc.nextInt();
        for(int i =0; i<shots; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
           int left = y - 1;
           int right = birds[x-1] - y;
            if(x < n){
                birds[x] += right;
            }
            if(x-2 >= 0){
                birds[x-2] += left;
            }
             birds[x-1] = 0;
        }
        for(int i = 0; i<n; i++){
            System.out.println(birds[i]);
        }

    }
}        

