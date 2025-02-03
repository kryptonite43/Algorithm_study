import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main1158 {
    public static void main(String[] args) throws Exception {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i=1; i<=n; i++) {
            q.addLast(i);
        }

        while (!q.isEmpty()) {
            for (int i=0; i<k-1; i++) {
                q.addLast(q.pollFirst());
            }
            int del = q.pollFirst();
            result.add(del);
        }
        StringBuilder sb = new StringBuilder(result.stream().map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println("<"+sb+">");
    }
}
