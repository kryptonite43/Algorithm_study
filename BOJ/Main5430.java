import java.util.*;
import java.io.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main5430 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            ArrayDeque<String> arr;
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringBuilder numsb = new StringBuilder(br.readLine());
            if (n==0) {
                arr = new ArrayDeque<>();
            }
            else {
                String nums = numsb.substring(1, numsb.length()-1);
                String[] arrs = nums.split(",");
                arr = new ArrayDeque<>(Arrays.asList(arrs));
            }
            boolean front = true, stop = false;
            // 각 명령어에 대해
            for (int j=0; j<p.length(); j++) {
                switch(p.charAt(j)) {
                    case 'R':
                        front = !front;
                        break;
                    case 'D':
                        if (!arr.isEmpty()) {
                            if (front) {
                                arr.pollFirst();
                            }
                            else {
                                arr.pollLast();
                            }
                        }
                        else {
                            bw.write("error\n");
                            stop = true;
                            j=p.length();
                        }
                        break;
                }
            }
            if (!stop) {
                String s;
                ArrayList<String> ans = new ArrayList<>(arr.stream().collect(Collectors.toList()));
                if (!front) {
                    //디집어
                    Collections.reverse(ans);
                }
                s = ans.stream().collect(Collectors.joining(","));
                bw.write("["+s+"]\n");
            }
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main5430().solution();
    }
}
