import java.util.*;
import java.io.*;

public class Main2805_1 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        List<Long> namus = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            long namu = Long.parseLong(st.nextToken());
            namus.add(namu);
        }
        Collections.sort(namus, Collections.reverseOrder());

        // 탐색 타겟: 절단기 높이 h의 값
        long high = namus.get(0); // 최장 나무 길이
        long low = 0;
        long answer = -1;
        while (high>=low) {
            long h = (high+low)/2;
            long sum = 0;
            // 현재 타겟인 h 값을 절단기 높이로 했을 때 현재 나무 잘린 길이의 합을 구한다
            for (int i=0; i<n; i++) {
                long curNamu = namus.get(i);
                if (curNamu > h)
                    sum += (curNamu - h);
                else
                    break;
            }
            // sum 과 목표 길이인 m을 비교
            if (sum == m) {
                System.out.println(h);
                return;
            }
            else if (sum < m) { // 더 잘라야 됨 -> 높이가 더 낮아져야 함
                high = h - 1;
            }
            else { // 덜 잘라야 됨 -> 높이가 더 높아져야 함
                // 일단 만족 -> 저장해 둔 후 m 이상의 길이를 뽑아낼 수 있는 더 큰 h가 있는지 탐색한다
                answer = Math.max(answer, h);
                low = h + 1;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main2805_1().solution();
    }
}
