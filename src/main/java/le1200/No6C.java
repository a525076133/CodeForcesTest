package le1200;

import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/19 09:29
 */
public class No6C {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] bars = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            bars[i] = in.nextInt();
            sum += bars[i];
        }

        int half = sum / 2;
        int count = 0;
        int halfIndex = -1;
        for (int i = 0; i < n; i++) {
            if (count + bars[i] > half) {
                halfIndex = i;
                break;
            }
            count += bars[i];
        }

        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < halfIndex; i++) {
            sumA += bars[i];
        }
        for (int i = halfIndex + 1; i < n; i++) {
            sumB += bars[i];
        }

        if (sumA > sumB) {
            System.out.println((halfIndex) + " " + (n - halfIndex));
        }else{
            System.out.println((halfIndex + 1) + " " + (n - halfIndex - 1));
        }

    }
}
