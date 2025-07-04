import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main4592 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
                return;
            else {
                ArrayDeque<Integer> stack = new ArrayDeque<>();
                for (int i = 0; i < n; i++) {
                    int x = Integer.parseInt(st.nextToken());
                    if (stack.isEmpty() || stack.peek() != x) {
                        stack.addFirst(x);
                    }
                }
                ArrayList<Integer> list = new ArrayList<>(stack.stream().collect(Collectors.toList()));
                Collections.reverse(list);
                StringBuilder sb = new StringBuilder(list.stream().map(Object::toString).collect(Collectors.joining(" ")));
                System.out.println(sb + " $");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main4592().solution();
    }
}
