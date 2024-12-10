import java.util.Arrays;

// Programmers - 두 개 뽑아서 더하기
public class Solution03 {
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
    }
}