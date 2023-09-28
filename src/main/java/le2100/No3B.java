package le2100;

import java.util.*;

/**
 * @Author bbbojack
 * @Date 2023/9/28 13:46
 */
public class No3B {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int v = in.nextInt();

        int[][] vehicles = new int[n][2];
        for (int i = 0; i < n; i++) {
            vehicles[i][0] = in.nextInt();
            vehicles[i][1] = in.nextInt();
        }

        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = 1.0 * vehicles[i][1] / vehicles[i][0];
        }

        Arrays.sort(arr, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o2[1] > o1[1]){
                    return 1;
                }else if(o1[1] > o2[1]){
                    return -1;
                }else{
                    return (int)(o1[0] - o2[0]);
                }
            }
        });
        int contains = 0;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int lastAddedTypeOne = -1;

        int skip = -1;
        for (int i = 0; i < n; i++) {
            int number = (int) arr[i][0];
            int type = vehicles[number][0];
            if (v >= type) {
                contains += vehicles[number][1];
                v -= type;
                list.add(number + 1);
                if (type == 1) {
                    lastAddedTypeOne = number;
                }
            }else {
                if (v == 0) {
                    break;
                }else if (v == 1 && type == 2) {
                    if(lastAddedTypeOne == -1){
                        break;
                    }
                    int typeTwoCarry = vehicles[number][1];
                    int typeOneCarry = vehicles[lastAddedTypeOne][1];
                    int nextTypeOne = findNextTypeOne(vehicles, arr, i);
                    if (nextTypeOne != -1) {
                        typeOneCarry += vehicles[nextTypeOne][1];
                    }
                    if (typeTwoCarry > typeOneCarry) {
                        skip = lastAddedTypeOne + 1;
                        list.add(number + 1);
                        contains += typeTwoCarry;
                        contains -= vehicles[lastAddedTypeOne][1];
                    }else{
                        if(nextTypeOne != -1){
                            list.add(nextTypeOne + 1);
                            contains += vehicles[nextTypeOne][1];
                        }
                    }
                    break;
                }
            }
        }

        System.out.println(contains);
        for (int ii : list) {
            if (ii == skip) {
                continue;
            }
            sb.append(ii);
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }

    public static int findNextTypeOne(int[][] vehicles, double[][] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            int number = (int) arr[i][0];
            int type = vehicles[number][0];
            if (type == 1) {
                return number;
            }
        }
        return -1;
    }
}
