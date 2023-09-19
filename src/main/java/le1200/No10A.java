package le1200;

import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/19 17:11
 */
public class No10A {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p1 = in.nextInt();
        int p2 = in.nextInt();
        int p3 = in.nextInt();
        int t1 = in.nextInt();
        int t2 = in.nextInt();

        int ans = 0;

        int lastTime = 0;
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();

            ans += (end - start) * p1;
            int period = start - lastTime;
            if(i == 0){
                lastTime = end;
                continue;
            }
            if (period > t1) {
                ans += t1 * p1;
                period -= t1;
                if (period > t2) {
                    ans += t2 * p2;
                    period -= t2;
                    ans += period * p3;
                } else {
                    ans += p2 * period;
                }
            } else {
                ans += p1 * period;
            }
            lastTime = end;
        }
        System.out.println(ans);
    }
}
