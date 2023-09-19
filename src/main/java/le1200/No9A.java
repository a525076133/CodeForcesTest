package le1200;

import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/19 15:43
 */
public class No9A {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int max = Math.max(a, b);
        switch(max){
            case 1:
                System.out.println("1/1");
                return;
            case 2:
                System.out.println("5/6");
                return;
            case 3:
                System.out.println("2/3");
                return;
            case 4:
                System.out.println("1/2");
                return;
            case 5:
                System.out.println("1/3");
                return;
            case 6:
                System.out.println("1/6");
                return;
        }
    }
}
