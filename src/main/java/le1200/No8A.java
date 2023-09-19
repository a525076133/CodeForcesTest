package le1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author bbbojack
 * @Date 2023/9/19 14:15
 */
public class No8A {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder flags = new StringBuilder(br.readLine());
        String first = br.readLine();
        String second =  br.readLine();

        boolean forward = false;
        boolean backward = false;
        int firstIndex = flags.indexOf(first);
        if(firstIndex != -1) {
            int secondIndex = flags.substring(firstIndex + first.length()).indexOf(second);
            if(secondIndex != -1){
                forward = true;
            }
        }

        flags.reverse();
        int reverseFirstIndex = flags.indexOf(first);
        if(reverseFirstIndex != -1) {
            int secondIndex = flags.substring(reverseFirstIndex + first.length()).indexOf(second);
            if(secondIndex != -1){
                backward = true;
            }
        }

        if(forward && backward){
            System.out.println("both");
        }else if (forward){
            System.out.println("forward");
        }else if(backward){
            System.out.println("backward");
        }else{
            System.out.println("fantasy");
        }

    }
}
