import java.math.BigInteger;
import java.util.Scanner;

public class ProductUVA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            BigInteger x = sc.nextBigInteger();
            BigInteger y = sc.nextBigInteger();

            BigInteger ans = x.multiply(y);
            System.out.println(ans);

        }
    }

}
