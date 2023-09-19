package le1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author bbbojack
 * @Date 2023/9/19 11:32
 */
public class No7A {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (new String(board[i]).equals("BBBBBBBB")) {
                count++;
            }
        }
        if (count == 8) {
            System.out.println(count);
            return;
        }

        for (int col = 0; col < 8; col++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb.append(board[i][col]);
            }
            if (sb.toString().equals("BBBBBBBB")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
