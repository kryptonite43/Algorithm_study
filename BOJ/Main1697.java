import java.util.*;
import java.io.*;
public class Main1697 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[100010];
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n==k) {
            System.out.println(0);
            return;
        }
        ArrayDeque<Integer> curq = new ArrayDeque<>();
        ArrayDeque<Integer> newq = new ArrayDeque<>();
        curq.addLast(n);
        int cnt = 1;
        do {
            while (!curq.isEmpty()) {
                int x = curq.pollFirst();
                int[] tmp = new int[]{x - 1, x + 1, 2 * x};
                for (int i = 0; i < 3; i++) {
                    if (tmp[i] >= 0 && tmp[i] <= 100000 && time[tmp[i]] == 0) {
                        time[tmp[i]] = cnt;
                        newq.addLast(tmp[i]);
                    }
                }
                //System.out.println(newq);
                if (time[k] != 0) {
                    System.out.println(time[k]);
                    return;
                }
            }
            curq = newq;
            newq = new ArrayDeque<>();
            cnt++;
            //System.out.println("다음 단계로: "+cnt);
        } while (time[k] == 0);


        /* 1. 입력을 위한 코드: Scanner 대신 BufferedReader 사용하기
         * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         * int n = Integer.parseInt(br.readLine());
         * ...
         * 2. 공백 기준 String 입력: str.split 대신 StringTokenizer 사용하기
         * StringTokenizer st = new StringTokenizer(br.readLine());
         * int s = Integer.parseInt(st.nextToken());
         * 3. 출력: System.out.println 대신 BufferedWriter/StringBuilder 사용하기
         * 1) BufferedWriter의 경우
         * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         * bw.write(String.valueOf(data)); // data는 int형
         * bw.newLine();
         * bw.flush();
         * 2)StringBuilder의 경우 (출력해야 할 것들을 모두 모아 sb에 저장 후 sb 출력)
         * StringBuilder sb = new StringBuilder();
         * for (int j=0; j<s; j++){
         *   sb.append(data).append('\n');
         * }
         * System.out.println(sb);
         * */
    }

    public static void main(String[] args) throws Exception {
        new Main1697().solution();
    }
}
