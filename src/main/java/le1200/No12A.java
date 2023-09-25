package le1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author bbbojack
 * @Date 2023/9/25 16:11
 */
public class No12A {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            board[i] = br.readLine().toCharArray();
        }

        if (board[0][0] != board[2][2] ||
                board[0][1] != board[2][1] ||
                board[0][2] != board[2][0] ||
                board[1][0] != board[1][2]) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
