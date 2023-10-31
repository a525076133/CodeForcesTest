package le1800;
import java.util.*;

/**
 * @Author bbbojack
 * @Date 2023/10/27 15:42
 */
public class No4D {

    /**
     * Peter decided to wish happy birthday to his friend from Australia and send him a card. To make his present more mysterious, he decided to make a chain. Chain here is such a sequence of envelopes A={a1,a2,...,an}, where the width and the height of the i-th envelope is strictly higher than the width and the height of the (i-1)-th envelope respectively. Chain size is the number of envelopes in the chain.
     *
     * Peter wants to make the chain of the maximum size from the envelopes he has, the chain should be such, that he'll be able to put a card into it. The card fits into the chain if its width and height is lower than the width and the height of the smallest envelope in the chain respectively. It's forbidden to turn the card and the envelopes.
     *
     * Peter has very many envelopes and very little time, this hard task is entrusted to you.
     *
     * Input
     * The first line contains integers n, w, h (1≤n≤5000, 1≤w,h≤106) — amount of envelopes Peter has, the card width and height respectively. Then there follow n lines, each of them contains two integer numbers wi and hi — width and height of the i-th envelope (1≤wi,hi≤106).
     *
     * Output
     * In the first line print the maximum chain size. In the second line print the numbers of the envelopes (separated by space), forming the required chain, starting with the number of the smallest envelope.
     * Remember, please, that the card should fit into the smallest envelope. If the chain of maximum size is not unique, print any of the answers.
     *
     * If the card does not fit into any of the envelopes, print number 0 in the single line.
     * @param args
     */

    /**
     * input
     * 2 1 1
     * 2 2
     * 2 2
     * output
     * 1
     * 1
     * <p>
     * input
     * 3 3 3
     * 5 4
     * 12 11
     * 9 8
     * output
     * 3
     * 1 3 2
     *
     * @param args
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cWidth = in.nextInt();
        int cHeight = in.nextInt();

        // envelopes
        int[][] envs = new int[n][3];
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            envs[i][0] = in.nextInt();
            envs[i][1] = in.nextInt();
            if (envs[i][0] > cWidth && envs[i][1] > cHeight) {
                flag = true;
            }
            envs[i][2] = i + 1;
        }


        Arrays.sort(envs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[n];
        int[] path = new int[n];

        if (!flag) {
            System.out.println(0);
        } else {
            for (int i = 0; i < n; i++) {
                if (cWidth < envs[i][0] && cHeight < envs[i][1]) {
                    int curMax = 0;
                    int maxIndex = -1;
                    for (int j = 0; j < i; j++) {
                        if (dp[j] > curMax && envs[i][0] > envs[j][0] && envs[i][1] > envs[j][1]) {
                            curMax = dp[j];
                            maxIndex = j;
                        }
                    }
                    dp[i] = curMax + 1;
                    path[i] = maxIndex;
                } else {
                    dp[i] = -1;
                    path[i] = -1;
                }
            }
//            System.out.println(Arrays.toString(dp));
//            System.out.println(Arrays.toString(path));
            int max = 0;
            int maxIndex = -1;
            for (int i = 0; i < n; i++) {
                if (dp[i] > max) {
                    max = dp[i];
                    maxIndex = i;
                }
            }
            System.out.println(max);
            List<Integer> ans = new ArrayList<>();
            while (maxIndex != -1) {
                ans.add(envs[maxIndex][2]);
                maxIndex = path[maxIndex];
            }

            for (int i = ans.size() - 1; i >= 0; i--) {
                System.out.print(ans.get(i));
                System.out.print(" ");
            }

        }

    }
}
