package le1200;

import java.util.*;

/**
 * @Author bbbojack
 * @Date 2023/9/26 10:38
 */
public class No12C {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = in.nextInt();
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String fruit = in.next();
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
        }

        Arrays.sort(price);
        Integer[] counts = new Integer[map.size()];
        map.values().toArray(counts);

        int max = 0;
        int min = 0;
        Arrays.sort(counts);

        for (int i = 0; i < counts.length; i++) {
            min += counts[counts.length - i - 1] * price[i];
            max += counts[counts.length - i - 1] * price[n - i - 1];
        }

        System.out.println(min + " " + max);
    }
}
