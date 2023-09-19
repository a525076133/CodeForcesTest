package le1200;

import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/19 16:02
 */
public class No9B {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int vBus = in.nextInt();
        int vStu = in.nextInt();
        int[] stops = new int[n];

        for (int i = 0; i < n; i++) {
            stops[i] = in.nextInt();
        }

        int x = in.nextInt();
        int y = in.nextInt();

        double minCost = Double.MAX_VALUE;
        int index = -1;
        for (int i = 1; i < n; i++) {
            double cost = getCost(stops[i], x, y, vBus, vStu);
            if (cost < minCost) {
                minCost = cost;
                index = i;
            } else if (cost == minCost) {
                if (getDist(stops[i], x, y) < getDist(stops[index], x, y)) {
                    index = i;
                }
            }
        }
        System.out.println(index + 1);

    }

    public static double getCost(int stopX, int xU, int yU, int vBus, int vStu) {
        return 1.0 * stopX / vBus + Math.sqrt(Math.pow((xU - stopX), 2) + yU * yU) / vStu;
    }

    public static double getDist(int stopX, int xU, int yU) {
        return Math.sqrt(Math.pow((xU - stopX), 2) + yU * yU);
    }
}
