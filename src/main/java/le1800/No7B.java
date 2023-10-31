package le1800;

/**
 * @Author bbbojack
 * @Date 2023/10/31 11:11
 */
import java.util.Scanner;

/**
 * B. Memory Manager
 * There is little time left before the release of the first national operating system BerlOS. Some of its components are not finished yet — the memory manager is among them. According to the developers' plan, in the first release the memory manager will be very simple and rectilinear. It will support three operations:
 * <p>
 * alloc n — to allocate n bytes of the memory and return the allocated block's identifier x;
 * erase x — to erase the block with the identifier x;
 * defragment — to defragment the free memory, bringing all the blocks as close to the beginning of the memory as possible and preserving their respective order;
 * The memory model in this case is very simple. It is a sequence of m bytes, numbered for convenience from the first to the m-th.
 * <p>
 * The first operation alloc n takes as the only parameter the size of the memory block that is to be allocated. While processing this operation, a free block of n successive bytes is being allocated in the memory. If the amount of such blocks is more than one, the block closest to the beginning of the memory (i.e. to the first byte) is prefered. All these bytes are marked as not free, and the memory manager returns a 32-bit integer numerical token that is the identifier of this block. If it is impossible to allocate a free block of this size, the function returns NULL.
 * <p>
 * The second operation erase x takes as its parameter the identifier of some block. This operation frees the system memory, marking the bytes of this block as free for further use. In the case when this identifier does not point to the previously allocated block, which has not been erased yet, the function returns ILLEGAL_ERASE_ARGUMENT.
 * <p>
 * The last operation defragment does not have any arguments and simply brings the occupied memory sections closer to the beginning of the memory without changing their respective order.
 * <p>
 * In the current implementation you are to use successive integers, starting with 1, as identifiers. Each successful alloc operation procession should return following number. Unsuccessful alloc operations do not affect numeration.
 * <p>
 * You are to write the implementation of the memory manager. You should output the returned value for each alloc command. You should also output ILLEGAL_ERASE_ARGUMENT for all the failed erase commands.
 * <p>
 * Input
 * The first line of the input data contains two positive integers t and m (1 ≤ t ≤ 100;1 ≤ m ≤ 100), where t — the amount of operations given to the memory manager for processing, and m — the available memory size in bytes. Then there follow t lines where the operations themselves are given. The first operation is alloc n (1 ≤ n ≤ 100), where n is an integer. The second one is erase x, where x is an arbitrary 32-bit integer numerical token. The third operation is defragment.
 * <p>
 * Output
 * Output the sequence of lines. Each line should contain either the result of alloc operation procession , or ILLEGAL_ERASE_ARGUMENT as a result of failed erase operation procession. Output lines should go in the same order in which the operations are processed. Successful procession of alloc operation should return integers, starting with 1, as the identifiers of the allocated blocks.
 */
public class No7B {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String ss = in.nextLine();

        int t = Integer.parseInt(ss.split(" ")[0]);
        int mem = Integer.parseInt(ss.split(" ")[1]);

        int[] memory = new int[mem];

        int allocOrder = 1;
        for (int i = 0; i < t; i++) {
            String s = in.nextLine();
            if (s.startsWith("alloc")) {
                String size = s.split(" ")[1];
                boolean res = allocMem(memory, Integer.parseInt(size), allocOrder);
                if (res) {
                    System.out.println(allocOrder++);
                } else {
                    System.out.println("NULL");
                }
            } else if (s.startsWith("erase")) {
                int num = Integer.parseInt(s.split(" ")[1]);
                if(num <= 0 || num > allocOrder){
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    continue;
                }else if(!erase(memory, num)){
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                }else{
//                    System.out.println("ok");
                }
            } else if (s.startsWith("defragment")) {
                defragment(memory);
//                System.out.println("defragment");
            }
//            System.out.println(Arrays.toString(memory));
        }
    }

    private static void defragment(int[] memory) {
        int j = 0;
        int i = 0;
        while (j < memory.length) {
            if (memory[j] != 0) {
                memory[i] = memory[j];
                if(j != i){
                    memory[j] = 0;
                }
                i++;
            }
            j++;
        }
    }

    private static boolean erase(int[] memory, int num) {
        boolean flag = false;
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == num) {
                flag = true;
                memory[i] = 0;
            }
        }
        return flag;
    }

    public static boolean allocMem(int[] memory, int size, int allocOrder) {

        int[] ints = canAlloc(memory, size);
        if (ints[0] == -1) {
            return false;
        } else {
            for (int i = ints[0]; i <= ints[1]; i++) {
                memory[i] = allocOrder;
            }
            return true;
        }
    }

    /**
     * int[0] - start
     * int[1] - end
     */

    public static int[] canAlloc(int[] memory, int size) {
        for (int i = 0; i < memory.length; i++) {
            int count = 0;
            if (memory[i] == 0) {
                for (int j = i; j < memory.length; j++) {
                    if (memory[j] == 0) {
                        count++;
                    }else{
                        i = j;
                        break;
                    }
                    if (count == size) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

}
