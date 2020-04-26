import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PatternMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            long num = Long.parseLong(br.readLine().trim());

            boolean out_ = isPattern(num);
            if (out_) wr.println("YES");
            else wr.println("NO");
        }

        wr.close();
        br.close();
    }

    static boolean isPattern(long num) {
        if (num == 1)
            return false;

        // write your code here
        while (num > 0) {
            if (!((num & 3L) == 2L || (num & 3L) == 1L))
                return false;

            num = num >>> 1;
        }

        return true;
    }
}