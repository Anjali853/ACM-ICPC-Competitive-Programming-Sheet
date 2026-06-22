import java.util.Scanner;

public class Juicer {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();

        int sum = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
        int orange = sc.nextInt();
        if(orange <= b){
            sum += orange;
            if(sum > d){
                count++;
                sum = 0;

            }
    }
}
System.out.println(count);

}
}