import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/** @noinspection NonAsciiCharacters*/
public class 배열_뒤집기 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 1, 1, 2})));
        System.out.println(Arrays.toString(solution(new int[]{1, 0, 1, 1, 1, 3, 5})));
    }

    public static int[] solution(int[] num_list) {
        /* 처음 코드
        int len = num_list.length;
        int[] answer = new int[len];

        for (int i = len-1; i>=0; i--) {
            answer[len-1-i] = num_list[i];
        }
        return answer;
        */

        List<Integer> integerList = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        Collections.reverse(integerList);
        return integerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
