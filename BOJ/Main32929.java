import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main32929 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        switch(x%3) {
            case 1: System.out.println("U"); break;
            case 2: System.out.println("O"); break;
            case 0: System.out.println("S"); break;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main32929().solution();
    }
}
