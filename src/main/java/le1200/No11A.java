package le1200;

import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/25 15:57
 */
public class No11A {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();

        int pre = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int now = in.nextInt();
            if (i == 0 || now > pre) {
                pre = now;
                continue;
            }

            int need = (pre - now) / d + 1;
            count += need;
            pre = now + need * d;

        }
        System.out.println(count);
    }

}
