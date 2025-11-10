import java.util.*;
import java.io.*;

public class Main1620 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> pokemon_nuna = new HashMap<>();
        HashMap<String, Integer> pokemon_nanu = new HashMap<>();
        // 도감 입력
        for (int i=1; i<=n; i++) {
            String name = br.readLine();
            pokemon_nuna.put(i, name);
            pokemon_nanu.put(name, i);
        }
        // 문제
        for (int i=0; i<m; i++) {
            String str = br.readLine();
            if (str.charAt(0)>='0' && str.charAt(0)<='9') { // 번호임
                int num = Integer.parseInt(str);
                System.out.println(pokemon_nuna.get(num));
            }
            else {
                System.out.println(pokemon_nanu.get(str));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main1620().solution();
    }
}
