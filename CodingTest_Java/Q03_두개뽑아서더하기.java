import java.util.Arrays;

/** @noinspection ALL*/ // Programmers https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class Q03_두개뽑아서더하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2,1,3,4,1})));
        System.out.println(Arrays.toString(solution(new int[]{5,0,2,7})));
    }

    private static int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n*(n-1)/2];
        int index = 0;

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                answer[index++] = numbers[i]+numbers[j];
            }
        }
        Integer[] intAns = Arrays.stream(answer).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(intAns);
        answer = Arrays.stream(intAns).mapToInt(i->i).toArray();
        return answer;

        /* set으로 중복 제거
        Set<Integer> set = new TreeSet<>();
        int n = numbers.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] ans = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return ans;
        */
    }
}