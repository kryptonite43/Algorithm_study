import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        
        for (int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x>0) pq.add(x);
            if (x==0) {
                if (pq.isEmpty()) bw.write(String.valueOf(0));
                else bw.write(String.valueOf(pq.poll()));
                bw.newLine();
            }
        }
        
        bw.flush();
    }
}