import java.io.*;
import java.util.*;
public class Main2503 {
    public void solution() throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> answerPool = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i=123; i<=987; i++) {
            // 수 abc
            String str = Integer.toString(i);
            int c = i%10;
            int b = (i/10)%10;
            int a = i/100;
            if (a!=b && b!=c && c!=a && b!=0 && c!=0) {
                answerPool.add(str);
            }
        }

        for (int i=0; i<n; i++) {
            ArrayList<String> tmp = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            String strguess = st.nextToken();
            char[] guess = strguess.toCharArray();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (String strnum: answerPool) {
                int checks = 0, checkb = 0;
                char[] num = strnum.toCharArray();
                // 스트라이크, 볼 체크
                for (int j=0; j<3; j++) {
                    String cur = strnum.substring(j,j+1);
                    if (num[j] == guess[j])
                        checks++;
                    else if (strguess.contains(cur))
                        checkb++;
                }
                if (checks == strike && checkb == ball) {
                    tmp.add(strnum);
                }
            }
            answerPool = new ArrayList<>(tmp);
        }
        System.out.println(answerPool.size());
    }

    public static void main(String[] args) throws Exception {
        new Main2503().solution();
    }
}
