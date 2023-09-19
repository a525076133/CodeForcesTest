package le1200;
import java.util.Scanner;

public class No4A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n - 2 > 0 && (n - 2)% 2 == 0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
