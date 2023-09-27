package le1800;

import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/26 11:09
 */
public class No1B {
    //    private static final String pattern = "";
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            String s = in.next();
            if (isRC(s)) {
                System.out.println(toABC(s));
            } else {
                System.out.println(toRC(s));
            }
        }
    }

    private static boolean isRC(String s) {
        if (s.charAt(0) != 'R' || !Character.isDigit(s.charAt(1))) {
            return false;
        }
        int i = 1;
        for (; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                break;
        }
        return i < s.length() && s.charAt(i) == 'C';
    }

    public static String toRC(String s) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                index = i;
                break;
            }
        }
        String col = s.substring(0, index);
        String row = s.substring(index);

        int colNum = 0;
        int base = 1;
        for (int i = col.length() - 1; i >= 0; i--) {
            colNum += ((col.charAt(i) - 'A' + 1) * base);
            base *= 26;
        }

        return "R" + row + "C" + colNum;
    }

    public static String toABC(String s) {
        StringBuilder ans = new StringBuilder();
        String row = s.substring(1, s.indexOf('C'));
        int col = Integer.parseInt(s.substring(s.indexOf('C') + 1));

        while (col > 0) {
            int res = col % 26;
            ans.append((char) ('A' - 1 + (res == 0 ? 26 : res)));
            col /= 26;
            if (res == 0) {
                col--;
            }
        }
        ans.reverse();
        ans.append(row);
        return ans.toString();
    }

}
