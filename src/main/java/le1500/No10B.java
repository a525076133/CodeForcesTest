package le1500;

import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/20 09:15
 * difficult 1500
 */
public class No10B {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        boolean[][] vis = new boolean[K + 1][K + 1];
        int mid = (K + 1) / 2;

        int round = N;
        while(round -- > 0){
            int num = in.nextInt();
            int min = Integer.MAX_VALUE;
            int x = -1;
            int y = -1;
            for (int i = 1; i <= K; i++) {
                for (int j = 1; j <= K; j++) {
                    if(vis[i][j]){
                        continue;
                    }
                    int result = calc(vis, i, j, mid, num, K);
                    if (result < min) {
                        min = result;
                        x = i;
                        y = j;
                    }
                }
            }
            if (min != Integer.MAX_VALUE) {
                for (int j = 0; j < num; j++) {
                    vis[x][y + j] = true;
                }
                System.out.println(x + " " + y + " " + (y + num - 1));
            } else {
                System.out.println(-1);
            }
        }
    }

    public static int calc(boolean[][] vis, int x, int y, int mid, int num, int K) {

        int sum = 0;
        for (int i = 0; i < num; i++) {
            if (y + i > K || vis[x][y + i]) {
                return Integer.MAX_VALUE;
            }
            sum += (Math.abs(mid - x) + Math.abs(y + i - mid));
        }
        return sum;
    }
}
