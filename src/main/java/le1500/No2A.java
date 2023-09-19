package le1500;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// difficult 1200
public class No2A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        int round = in.nextInt();

        String[] names = new String[round];
        int[] scores = new int[round];

        for(int i = 0; i < round; i ++) {
            String name = in.next();
            int score = in.nextInt();
            names[i] = name;
            scores[i] = score;
            map.put(name, map.getOrDefault(name, 0) + score);
        }

        Integer max = Collections.max(map.values());
        Map<String, Integer> check = new HashMap<>();
        String winner = "";
        for (int i = 0; i < round; i++) {
            int now = scores[i] + check.getOrDefault(names[i], 0);
            if(now >= max && map.get(names[i]) >= max){
                winner = names[i];
                break;
            }
            check.put(names[i], now);
        }
        System.out.println(winner);
    }
}
