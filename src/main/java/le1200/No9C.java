package le1200;

import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/19 16:27
 */
public class No9C {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int count = 0;
//        for (int i = 1; i <= n; i++) {
//            String number = String.valueOf(i);
//            String replace1 = number.replaceAll("1", "");
//            String replace2 = replace1.replaceAll("0", "");
//            if (replace2.length() == 0) {
//                count++;
//            }
//        }
//        System.out.println(count);

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            String binary = Integer.toBinaryString(i);
            Integer number = Integer.parseInt(binary);
            if(number <= n){
                count ++;
            }else{
                break;
            }
        }
        System.out.println(count);
    }
}
