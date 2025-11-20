import java.util.*;
import java.io.*;

public class Main1541 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
        List<String> opers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            opers.add(st.nextToken());
        }

        boolean minusflag = false;
        boolean checkflag = false;
        int a = 0, b = 0;
        for (int i=0; i<opers.size(); i++) {
            String s = opers.get(i);
            switch(s) {
                case "+":
                    break;
                case "-":
                    if (minusflag) checkflag = true;
                    minusflag = true;
                    break;
                default: // 숫자
                    int x = Integer.parseInt(s);
                    if (i==0) { // 초기 값 설정
                        a = x;
                        continue;
                    }
                    if (i != 0 && checkflag) {
                        a = a-b;
                        b = 0;
                        b += x;
                        minusflag = true;
                        checkflag = false;
                    }
                    else if (minusflag) {
                        b += x;
                    }

                    else { // + 기호
                        a += x;
                    }
            }
        }
        if (b != 0 && minusflag) {
            a = a-b;
        }
        else if (b != 0) {
            a = a+b;
        }
        System.out.println(a);
    }


    public static void main(String[] args) throws Exception {
        new Main1541().solution();
    }
}
