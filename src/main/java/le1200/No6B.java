package le1200;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author bbbojack
 * @Date 2023/9/18 17:49
 */
public class No6B {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        String s = in.next();
        char color = s.toCharArray()[0];

        char[][] seats = new char[row][col];
        for (int i = 0; i < row; i++) {
            seats[i] = in.next().toCharArray();
        }

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(seats[i][j] == color){
                    if(i - 1 >= 0 && seats[i - 1][j] != '.' && seats[i - 1][j] != color){
                        set.add(seats[i - 1][j]);
                    }
                    if(i + 1 < row && seats[i + 1][j] != '.' && seats[i + 1][j] != color){
                        set.add(seats[i + 1][j]);
                    }
                    if(j - 1 >= 0 && seats[i][j - 1] != '.' && seats[i][j - 1] != color){
                        set.add(seats[i][j - 1]);
                    }
                    if(j + 1 < col && seats[i][j + 1] != '.' && seats[i][j + 1] != color){
                        set.add(seats[i][j + 1]);
                    }
                }
            }
        }
        System.out.println(set.size());
    }
}
