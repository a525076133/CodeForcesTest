package le1500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author bbbojack
 * @Date 2023/9/19 14:29
 */
public class No8B {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder path = new StringBuilder(br.readLine());
        Set<String> set = new HashSet<>();

        int x = 0;
        int y = 0;
        set.add(x + "," + y);
        for (int i = 0; i < path.length(); i++) {
            char move = path.charAt(i);
            switch (move) {
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
            boolean check = check(x, y, set);
            set.add(x + "," + y);
            if (!check) {
                System.out.println("BUG");
                return;
            }
        }
        System.out.println("OK");
    }

    public static boolean check(int x, int y, Set<String> set) {

        int count = 0;
        if (set.contains(x + "," + y)){
            return false;
        }
        String leftUp = (x - 1) + "," + (y + 1);
        String up = x + "," + (y + 1);
        String rightUp = (x + 1) + "," + (y + 1);
        String left = (x - 1) + "," + y;
        String right = (x + 1) + "," + y;
        String leftDown = (x - 1) + "," + (y - 1);
        String down = x + "," + (y - 1);
        String rightDown = (x + 1) + "," + (y - 1);

        if (set.contains(leftUp)) {
            count++;
        }
        if (set.contains(up)) {
            count++;
        }
        if (set.contains(rightUp)) {
            count++;
        }
        if (set.contains(left)) {
            count++;
        }
        if (set.contains(right)) {
            count++;
        }
        if (set.contains(leftDown)) {
            count++;
        }
        if (set.contains(down)) {
            count++;
        }
        if (set.contains(rightDown)) {
            count++;
        }
        return count < 3;
    }

}
