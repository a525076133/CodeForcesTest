package le1200;

import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/15 10:35
 */

public class No3A {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String start = in.next();
        String end = in.next();

        char x1 = start.charAt(0);
        char x2 = end.charAt(0);
        char y1 = start.charAt(1);
        char y2 = end.charAt(1);

        // x1<x2 R else L
        // y1<y2 U else D
        final String UP = "U";
        final String DOWN = "D";
        final String LEFT = "L";
        final String RIGHT = "R";

        int step = 0;
        StringBuilder ans = new StringBuilder();
        while(x1 != x2 || y1 != y2){
            step ++;
            if(x1 < x2){
                ans.append(RIGHT);
                x1++;
            }else if(x1 > x2){
                ans.append(LEFT);
                x1--;
            }

            if(y1 < y2){
                y1 ++;
                ans.append(UP);
            }else if(y1 > y2){
                y1 --;
                ans.append(DOWN);
            }
            ans.append('\n');
        }
        System.out.println(step);
        System.out.println(ans);
    }
}
