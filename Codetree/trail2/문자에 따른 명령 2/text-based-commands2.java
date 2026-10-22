import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cmd = br.readLine();
        
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int dir=1, x=0, y=0;

        for (int i=0; i<cmd.length(); i++) {
            switch(cmd.charAt(i)) {
                case 'L':
                    dir = (dir+1)%4;
                    break;
                case 'R':
                    dir = (dir+3)%4;
                    break;
                case 'F':
                    x = x + dx[dir];
                    y = y + dy[dir];
            }
        }
        System.out.printf("%d %d", x, y);
    }
}