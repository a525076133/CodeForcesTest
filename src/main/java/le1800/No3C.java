package le1800;

/**
 * @Author bbbojack
 * @Date 2023/10/27 13:34
 */

import java.util.Scanner;

/**
 * Certainly, everyone is familiar with tic-tac-toe game. The rules are very simple indeed. Two players take turns marking the cells in a 3×3 grid (one player always draws crosses, the other — noughts). The player who succeeds first in placing three of his marks in a horizontal, vertical or diagonal line wins, and the game is finished. The player who draws crosses goes first. If the grid is filled, but neither Xs, nor 0s form the required line, a draw is announced.
 * <p>
 * You are given a 3×3 grid, each grid cell is empty, or occupied by a cross or a nought. You have to find the player (first or second), whose turn is next, or print one of the verdicts below:
 * <p>
 * illegal — if the given board layout can't appear during a valid game;
 * the first player won — if in the given board layout the first player has just won;
 * the second player won — if in the given board layout the second player has just won;
 * draw — if the given board layout has just let to a draw.
 * Input
 * The input consists of three lines, each of the lines contains characters ".", "X" or "0" (a period, a capital letter X, or a digit zero).
 * <p>
 * Output
 * Print one of the six verdicts: first, second, illegal, the first player won, the second player won or draw.
 * <p>
 * Examples
 * inputCopy
 * X0X
 * .0.
 * .X.
 * outputCopy
 * second
 */

public class No3C {

    public static void main(String[] args) {

        char[][] board = new char[3][3];
        Scanner in = new Scanner(System.in);
        board[0] = in.next().toCharArray();
        board[1] = in.next().toCharArray();
        board[2] = in.next().toCharArray();

        int count0 = 0;
        int countX = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    countX++;
                } else if (board[i][j] == '0') {
                    count0++;
                }
            }
        }

        if (count0 > countX || countX - count0 > 1) {
            System.out.println("illegal");
            return;
        }


        int judge = judge(board);

        if (judge == 0) {
            System.out.println("illegal");
            return;
        } else if (judge != -1) {
            // somebody wins
            if (judge == 2 && count0 == countX) {
                System.out.println("the second player won");
            } else if (judge == 1 && countX - count0 == 1) {
                System.out.println("the first player won");
            } else {
                System.out.println("illegal");
            }
        } else {
            // draw
            if (count0 + countX == 9) {
                System.out.println("draw");
            } else if (count0 == countX) {
                System.out.println("first");
            } else {
                System.out.println("second");
            }
        }
    }

    /**
     * @ return -1 - nobody wins
     * 0 - X win
     * 1 - 0 win
     */
    public static int judge(char[][] b) {
        int tag1 = -1;
        int tag2 = -1;
        int count = 0;
        if (b[0][0] != '.' && b[0][0] == b[0][1] && b[0][0] == b[0][2]) {
            if (b[0][0] == 'X') {
                tag1 = 1;
                count++;
            } else {
                tag2 = 2;
                count++;
            }
        }

        if (b[1][0] != '.' && b[1][0] == b[1][1] && b[1][0] == b[1][2]) {
            if (b[1][0] == 'X') {
                tag1 = 1;
                count++;
            } else {
                tag2 = 2;
                count++;
            }
        }

        if (b[2][0] != '.' && b[2][0] == b[2][1] && b[2][0] == b[2][2]) {
            if (b[2][0] == 'X') {
                tag1 = 1;
                count++;
            } else {
                tag2 = 2;
                count++;
            }
        }

        if (b[0][0] != '.' && b[0][0] == b[1][1] && b[0][0] == b[2][2]) {
            if (b[0][0] == 'X') {
                tag1 = 1;
                count++;
            } else {
                tag2 = 2;
                count++;
            }
        }

        if (b[0][2] != '.' && b[0][2] == b[1][1] && b[0][2] == b[2][0]) {
            if (b[0][2] == 'X') {
                tag1 = 1;
                count++;
            } else {
                tag2 = 2;
                count++;
            }
        }

        if (b[0][0] != '.' && b[0][0] == b[1][0] && b[0][0] == b[2][0]) {
            if (b[0][0] == 'X') {
                tag1 = 1;
                count++;
            } else {
                tag2 = 2;
                count++;
            }
        }

        if (b[0][1] != '.' && b[0][1] == b[1][1] && b[0][1] == b[2][1]) {
            if (b[0][1] == 'X') {
                tag1 = 1;
                count++;
            } else {
                tag2 = 2;
                count++;
            }
        }

        if (b[0][2] != '.' && b[0][2] == b[1][2] && b[0][2] == b[2][2]) {
            if (b[0][2] == 'X') {
                tag1 = 1;
                count++;
            } else {
                tag2 = 2;
                count++;
            }
        }

        if (count > 1 && tag1 == 1 && tag2 == 2) {
            return 0;
        } else {
            return tag1 == -1 ? tag2 == -1 ? -1 : tag2 : tag1;
        }
    }




}
