package le1200;

import java.util.Scanner;

/**
 * @Author bbbojack
 * @Date 2023/9/18 17:13
 */
public class No6A {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] nums = new int[4];
        nums[0] = in.nextInt();
        nums[1] = in.nextInt();
        nums[2] = in.nextInt();
        nums[3] = in.nextInt();

        boolean t1 = false;
        boolean t2 = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(j == i){
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    if(k == i || k == j){
                        continue;
                    }
                    if(nums[i] + nums[j] == nums[k] ||
                        nums[i] + nums[k] == nums[j] ||
                        nums[k] + nums[j] == nums[i]
                    ){
                        t2 = true;
                    }
                    if(nums[i] + nums[j] > nums[k] &&
                            nums[i] + nums[k] > nums[j] &&
                            nums[k] + nums[j] > nums[i]
                    )
                        t1 = true;
                }
            }
        }

        if(t1){
            System.out.println("TRIANGLE");
        }else if(t2){
            System.out.println("SEGMENT");
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }
}
