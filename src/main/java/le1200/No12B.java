package le1200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/26 09:20
 */
public class No12B {

    private static final String WRONG = "WRONG_ANSWER";
    private static final String OK = "OK";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String inputStr = in.next();
        String outputStr = in.next();

        if (outputStr.length() != 1 && outputStr.charAt(0) == '0') {
            System.out.println(WRONG);
        } else if (outputStr.length() != inputStr.length()) {
            System.out.println(WRONG);
        } else {
            char[] chars = inputStr.toCharArray();
            Arrays.sort(chars);
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] != '0'){
                    if(i != 0) {
                        chars[0] = chars[i];
                        chars[i] = '0';
                    }
                    break;
                }
            }
            String ans = String.valueOf(chars);
            if(outputStr.equals(ans)){
                System.out.println(OK);
            }else{
                System.out.println(WRONG);
            }
        }
    }
}

