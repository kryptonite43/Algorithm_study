import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int x = 0, y = 0;
        int[] dx = {0,-1,0,1};
        int[] dy = {1,0,-1,0};

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int d = Integer.parseInt(st.nextToken());
            
            int ind = 0;
            switch(dir) {
                case 'E': ind = 3; break;
                case 'N': ind = 0; break;
                case 'W': ind = 1; break;
                case 'S': ind = 2; break;

            }
            x = x + dx[ind]*d;
            y = y + dy[ind]*d;

        }
        System.out.printf("%d %d", x, y);

    }
}