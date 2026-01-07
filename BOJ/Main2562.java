import java.util.*;
import java.io.*;
public class Main2562 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for (int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max);
        for (int i=0; i<9; i++) {
            if (arr[i]==max) System.out.println(i+1);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2562().solution();
    }
}
