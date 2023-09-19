package le1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author bbbojack
 * @Date 2023/9/18 13:56
 */
public class No5A {
    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        int online = 0;
//        int ans = 0;
//        while(in.hasNext()) {
//            StringBuilder opt = new StringBuilder(in.nextLine());
//            if(opt.charAt(0) == '+'){
//                online ++;
//            }else if (opt.charAt(0) == '-'){
//                online --;
//            }else{
//                int i = opt.length() - opt.indexOf(":") - 1;
//                ans += (i * online);
//            }
//        }
//        System.out.println(ans);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int online = 0;
        int ans = 0;
        while (br.ready()) {
            StringBuilder opt = new StringBuilder(br.readLine());
            if(opt.charAt(0) == '+'){
                online ++;
            }else if (opt.charAt(0) == '-'){
                online --;
            }else{
                int i = opt.length() - opt.indexOf(":") - 1;
                ans += (i * online);
            }
        }
        System.out.println(ans);
    }
}
