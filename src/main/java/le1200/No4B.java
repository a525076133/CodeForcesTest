package le1200;

import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/15 11:52
 */
public class No4B {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int days = in.nextInt();
        int sum = in.nextInt();
        int[][] times = new int[days][2];

        // [i][0] - min
        // [i][1] - max

        int count = 0;
        int mins = 0;
        int[] ans = new int[days];
        for (int i = 0; i < days; i++) {
            times[i][0] = in.nextInt();
            times[i][1] = in.nextInt();
            mins += times[i][0];
            ans[i] = times[i][0];
            count += times[i][1];
        }


        if(count < sum || mins > sum){
            System.out.println("NO");
        }else{
            int now = mins;
            for (int i = 0; i < days; i++) {

                if(sum - now > times[i][1] - times[i][0]){
                    ans[i] = times[i][1];
                    now += times[i][1] - times[i][0];
                }else if(sum - now == times[i][1] - times[i][0]){
                    ans[i] = times[i][1];
                    break;
                }else{
                    ans[i] += sum - now;
                    break;
                }
            }

            System.out.println("YES");
            for (int i = 0; i < days; i++) {
                if(i != 0){
                    System.out.print(' ');
                }
                System.out.print(ans[i]);
            }
        }
    }
}
