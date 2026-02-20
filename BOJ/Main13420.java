import java.io.*;
import java.util.*;
public class Main13420 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            String str="";
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            char op = st.nextToken().charAt(0);
            long b = Long.parseLong(st.nextToken());
            st.nextToken();
            long ans = Long.parseLong(st.nextToken());
            switch(op) {
                case '+':
                    str = (a+b==ans)?"correct":"wrong answer";
                    break;
                case '-':
                    str = (a-b==ans)?"correct":"wrong answer";
                    break;
                case '*':
                    str = (a*b==ans)?"correct":"wrong answer";
                    break;
                case '/':
                    str = (a/b==ans)?"correct":"wrong answer";
                    break;
            }
            bw.write(str);
            bw.newLine();
        }
        bw.flush();

    }

    public static void main(String[] args) throws Exception {
        new Main13420().solution();
    }
}
