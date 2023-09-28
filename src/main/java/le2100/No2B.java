package le2100;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @Author bbbojack
 * @Date 2023/9/27 09:45
 */
public class No2B {
    public static void main(String[] args) throws IOException {

        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int[][] matrix = new int[n][n];

        boolean hasZero = false;
        int zeroRow = -1;
        int zeroCol = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = fs.nextInt();
                if (matrix[i][j] == 0) {
                    hasZero = true;
                    zeroRow = i;
                    zeroCol = j;
                }
            }
        }

        int[][] dp2 = new int[n][n];
        int[][] dp5 = new int[n][n];
        char[][] path2 = new char[n][n];
        char[][] path5 = new char[n][n];

        dp2[0][0] = getTwo(matrix[0][0]);
        dp5[0][0] = getFive(matrix[0][0]);

        for (int i = 1; i < n; i++) {
            dp2[0][i] = dp2[0][i - 1] + getTwo(matrix[0][i]);
            dp5[0][i] = dp5[0][i - 1] + getFive(matrix[0][i]);
            dp2[i][0] = dp2[i - 1][0] + getTwo(matrix[i][0]);
            dp5[i][0] = dp5[i - 1][0] + getFive(matrix[i][0]);
            path2[0][i] = 'R';
            path5[0][i] = 'R';
            path2[i][0] = 'D';
            path5[i][0] = 'D';
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp2[i][j] = getTwo(matrix[i][j]) + Math.min(dp2[i - 1][j], dp2[i][j - 1]);
                dp5[i][j] = getFive(matrix[i][j]) + Math.min(dp5[i - 1][j], dp5[i][j - 1]);
                path2[i][j] = dp2[i - 1][j] < dp2[i][j - 1] ? 'D' : 'R';
                path5[i][j] = dp5[i - 1][j] < dp5[i][j - 1] ? 'D' : 'R';
            }
        }

        if (hasZero && Math.min(dp2[n - 1][n - 1], dp5[n - 1][n - 1]) > 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < zeroCol; i++) {
                sb.append('R');
            }
            for (int i = 0; i < n - 1; i++) {
                sb.append('D');
            }
            for (int i = zeroCol; i < n - 1; i++) {
                sb.append('R');
            }
            System.out.println(1);
            System.out.println(sb.toString());
            return;
        }

        if (dp2[n - 1][n - 1] < dp5[n - 1][n - 1]) {
            System.out.println(dp2[n - 1][n - 1]);
            System.out.println(getPath(n, path2));
        } else {
            System.out.println(dp5[n - 1][n - 1]);
            System.out.println(getPath(n, path5));
        }
    }

    private static String getPath(int n, char[][] path) {
        int r = n - 1;
        int c = n - 1;
        StringBuilder sb = new StringBuilder();
        while (r != 0 || c != 0) {
            char ch = path[r][c];
            sb.append(ch);
            if (ch == 'D') {
                r--;
            } else {
                c--;
            }
        }
        return sb.reverse().toString();
    }

    private static int getTwo(int num) {
        return get(num, 2);
    }

    private static int getFive(int num) {
        return get(num, 5);
    }

    private static int get(int num, int div) {
        int count = 0;
        while (num % div == 0 && num > 0) {
            count++;
            num /= div;
        }
        return count;
    }

    private static class FastScanner {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        private FastScanner() throws IOException {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private short nextShort() throws IOException {
            short ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do ret = (short) (ret * 10 + c - '0');
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return (short) -ret;
            return ret;
        }

        private int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do ret = ret * 10 + c - '0';
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do ret = ret * 10 + c - '0';
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        private char nextChar() throws IOException {
            byte c = read();
            while (c <= ' ') c = read();
            return (char) c;
        }

        private String nextString() throws IOException {
            StringBuilder ret = new StringBuilder();
            byte c = read();
            while (c <= ' ') c = read();
            do {
                ret.append((char) c);
            } while ((c = read()) > ' ');
            return ret.toString();
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

}
