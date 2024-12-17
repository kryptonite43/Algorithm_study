import java.util.Arrays;

public class Solution06 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4,4,4,4,4})));
    }

    public static int[] solution(int n, int[] stages) {
        double[][] failRate = new double[n+1][2];
        int[] counti = new int[n+2];
        int[] presum = new int[n+2];
        int[] answer = new int[n];
        int index = 0;
        // 실패율 구하기 전 필요한 값 셋업
        // 1. stages[] 내 값이 i인 것 개수: counti[i]
        for (int i=0; i<stages.length; i++) { // stages[] 한 바퀴
            counti[stages[i]]++;
        }
        // 2. stages[] 내 i보다 큰 값의 개수: presum[i]
        presum[n+1] = counti[n+1];
        for (int i=n; i>0; i--) {
            presum[i] = counti[i] + presum[i+1];
        }

        for (int i=1; i<=n; i++) { // i번 스테이지의 실패율 구하기
            if (counti[i]==0) {
                failRate[i][0] = 0;
            }
            else {
                failRate[i][0] = (double)counti[i]/presum[i];
            }
            failRate[i][1] = i;
        }


        Arrays.sort(failRate, (o1, o2) -> {
            if (o1[0] != o2[0]) { // 실패율 내림차순
                return Double.compare(o2[0], o1[0]);
            } else { // 실패율 같으면 스테이지 오름차순
                return (int) (o1[1]- o2[1]);
            }
        });

        for (int i=0; i<failRate.length; i++) {
            if (Double.compare(failRate[i][1], 0.0) == 0) {continue;}
            answer[index++] = (int) failRate[i][1];
        }

        /*
        HashMap<Integer, Double> fails = new HashMap<>(); // key: 스테이지 번호, value: 실패율
        // 값 기준 내림차순 정렬 후 키만 배열에 담아 반환
        return fails.entrySet().stream().sorted((o1, o2) ->
        Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
	    */
        return answer;
    }

}
