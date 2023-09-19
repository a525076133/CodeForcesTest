package le1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author bbbojack
 * @Date 2023/9/18 16:24
 */
public class No5B {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        List<String> strs = new ArrayList<>();
        int maxLen = -1;
        while(input != null){
            strs.add(input);
            maxLen = Math.max(maxLen, input.length());
            input = br.readLine();
        }

        StringBuilder ans = new StringBuilder();
        ans.append(getStar(maxLen+2));
        ans.append('\n');
        
        boolean left = true;
        for (int i = 0; i < strs.size(); i++) {
            int diff = maxLen - strs.get(i).length();
            if(diff % 2 == 0){
                ans.append(getAns(strs.get(i),diff/2,diff/2));
            }else{
                if(left){
                    ans.append(getAns(strs.get(i),diff/2,diff/2 + 1));
                }else{
                    ans.append(getAns(strs.get(i),diff/2 + 1,diff/2));
                }
                left = !left;
            }
        }
        ans.append(getStar(maxLen+2));
        System.out.println(ans);
    }

    public static String getSpace(int count){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String getStar(int count){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append('*');
        }
        return sb.toString();
    }

    public static String getAns(String str, int leftSpace, int rightSpace){
        StringBuilder sb = new StringBuilder();
        sb.append('*');
        sb.append(getSpace(leftSpace));
        sb.append(str);
        sb.append(getSpace(rightSpace));
        sb.append('*');
        sb.append('\n');
        return sb.toString();
    }
}
