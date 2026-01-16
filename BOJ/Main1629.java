import java.util.*;
import java.io.*;

public class Main1629 {
    public void solution() throws Exception {
        /* 곱셈 / 0.5sec
         * 자연수 a를 b번 곱한 수 -> 이를 c 로 나눈 나머지
         * input
         * a b c -> int 범위 내의 자연수
         * (a*a*a*a*a*a)/c
         * ex. 10을 11번 , 12로 나눔
         * 10 pow 11
         * 뭘 해도 연산을 21억번 할 순 없음
         * 규칙을 찾아서 계산해야 할 거 같음
         * 9 6 14 해보면
         * 답은 1
         * 9 -> 나머지 9
         * 9*9 -> 나머지 11
         * 9*9*9 -> 나머지 1
         * 9*9*9*9 -> 나머지 9
         * 9*9*9*9*9 -> 나머지 11 * 9
         * 9*9*9*9*9*9 ->
         * - 나머지 종류가 반복됨. 나머지 개수는 0~c-1 이므로 int[c] 배열을 만들어 관리
         * - 초반에 반복 구간을 찾으면 구하기 break.
         * - 특정 구간부터 반복이 된다면 -. 일단 [1] or [2] 에서 무조건 반복 시작됨
         * - 남은 연산 횟수 (b-i)에 대해 해당하는 나머지 구해서 출력
         * 현재 수     나머지
         * 10     ->  10
         * 100    ->  4
         * 1000   ->  4
         * 10000  4
         *
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int res = 1;
        int size = 0;
        int ans = 0;
        int[] remain = new int[100000]; // remain[0]부터 시작
        Arrays.fill(remain, -1);
        for (int i=0; i<b; i++) { // a를 i번 곱한 상태를 체크하고 있는 것임
            res *= a;
            int tmp = res%c;
            res = tmp;
            if (tmp == remain[0]) {
                size = i;
                ans = b%size==0 ? remain[size-1] : remain[b%size-1];
                // i-1번까지 진행했음 -> b번 곱해야 되니까 b-i+1번 더 해야 돼
                // i=4에서 break 됨. size = 3. b = 6이고 6-4+1 = 3.
                // 3%size = 0. 0이면 마지막 원소 1이면 1번 원소
                break;
            }
            else if (tmp == remain[1]) {
                // 2번 원소부터 돌림
                // 11번 곱해야 됨. 근데 1번 건너뛰고 3개씩 반복됨.
                // 최종 b번 체크해야 됨 -> (b-i) 번 더 해야 됨
                // i = 4에서 break, size = 2. ex. 10, 4, 2, 4, 2,...
                // 10 4 2 4 2 4 2 4 2 4 2. 10번에 대해 2로 나눈 나머지 -> 0. 0이면 size.
                size = i-1; // 첫 원소 제외
                //System.out.println(size);
                ans = (b-1)%size==0?remain[size]:remain[(b-1)%size];
                break;
            }
            remain[i] = tmp;
            //System.out.printf("remain[%d] = %d\n", i, tmp);
            ans = tmp;

        }
        //System.out.println(Arrays.toString(remain));
        System.out.println(ans);
        // 3(size)개 돌리는데 6(b)번 실행 -> 123 123 (b+2)%size.
    }

    public static void main(String[] args) throws Exception {
        new Main1629().solution();
    }
}
