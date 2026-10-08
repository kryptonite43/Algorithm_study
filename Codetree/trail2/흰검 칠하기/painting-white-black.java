import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        char[] dir = new char[n];
        
        //흰색, 검은색 각각 2번 이상이면 회색으로 바뀌고 더이상 바뀌지 않음
        // 명령 1000번, x 는 100 가능 -> +- 10만 의 값이 가능. 따라서 10만을 더하고 시작함.
        // 10만에서 시작, 범위는 20만
        int[] white = new int[200000];
        int[] black = new int[200000];
        char[] color = new char[200000]; // w, b, g
        
        int cur = 100000;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);

            switch(dir[i]) {
                case 'L': // 5에서 시작해서 3 L 하면 5 4 3 이니까 3, 5
                    for (int j = cur-x[i]+1; j<=cur; j++) {
                        if (color[j]!='g') {
                            white[j]++;
                        }
                        if (white[j]>=2 && black[j]>=2) {
                            color[j]='g';
                        }
                        else {
                            color[j]='w';
                        }
                    }
                    cur = cur-x[i]+1;
                    break;
                case 'R':
                    for (int j = cur; j<=cur+x[i]-1; j++) {
                        if (color[j]!='g') {
                            black[j]++;
                        }
                        if (white[j]>=2 && black[j]>=2) {
                            color[j]='g';
                        }
                        else {
                            color[j]='b';
                        }
                    }
                    cur = cur+x[i]-1;
                    break;
            }
        }
        
        // Stream<Character> charStream = new String(charArr)
        // .chars().mapToObj(c -> (char) c);
        Stream<Character> charStream = new String(color).chars().mapToObj(c -> (char) c);
        int whi = (int) new String(color).chars().mapToObj(c -> (char) c)
                    .filter(it ->it=='w').count();
        int bla = (int) new String(color).chars().mapToObj(c -> (char) c)
                    .filter(it ->it=='b').count();
        int gry = (int) new String(color).chars().mapToObj(c -> (char) c)
                    .filter(it ->it=='g').count();

        System.out.println(whi+" "+bla+" "+gry);
    }
}