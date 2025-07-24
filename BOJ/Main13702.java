import java.util.*;
import java.io.*;

public class Main13702 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n==0) {
            System.out.println(0);
            return;
        }
        long[] drink = new long[n];

        for (int i=0; i<n; i++) {
            drink[i] = Long.parseLong(br.readLine());
        }

        long high = Arrays.stream(drink).max().getAsLong();
        long low = 1;
        long finalAns = 0;


        while (high >= low) {
            long mid = (high+low)/2; // mid 용량으로 k명에게 분배하는 경우를 살펴본다.
            if (mid == 0) {
                high = mid - 1;
                continue;
            }
            long quoSum = 0;
            for (int i=0; i<n; i++) {
                quoSum += (drink[i]/mid);
            }
            if (quoSum >= k) {
                finalAns = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        System.out.println(finalAns);
    }

    public static void main(String[] args) throws Exception {
        new Main13702().solution();
    }
}
