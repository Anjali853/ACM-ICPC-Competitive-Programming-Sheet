import java.util.Scanner;

public class FreeIceCream{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        int distress = 0;

        for(int i = 0; i <n; i++){
             char sign = sc.next().charAt(0);
              long d = sc.nextLong();

            if(sign == '+'){
                x += d;
            }
            else{
            if(x >= d){
                x -= d;

            } else{
                distress++;

            }
        }
            
    }
    System.out.println(x +" "+distress);
}
}