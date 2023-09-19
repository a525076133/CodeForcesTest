package le1500;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/18 11:32
 * difficulty 1300
 */
public class No4C {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = in.next();
            if (!map.containsKey(name)) {
                System.out.println("OK");
                map.put(name, 1);
            } else {
                int count = map.get(name);
                String newName = name + count;
                map.put(name, count + 1);
                System.out.println(newName);
            }
        }

    }
}
