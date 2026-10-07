import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        int n = numbers.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] ans = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return ans;
        /*int n = numbers.length;
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
        return answer;*/
    }
}