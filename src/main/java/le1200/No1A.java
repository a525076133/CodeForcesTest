package le1200;

import java.util.Scanner;

public class No1A {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();

        long height = n / a + (n % a == 0 ? 0 : 1);
        long width = m / a + (m % a == 0 ? 0 : 1);
        System.out.println(height * width);
    }
}
