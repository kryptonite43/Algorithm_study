import java.util.*;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4,2,2,1,3,4})));
        System.out.println(Arrays.toString(solution(new int[]{2,1,1,3,2,5,4})));
    }

    private static int[] solution(int[] arr) {
        /*List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<Integer>(list);
        List<Integer> newList = new ArrayList<Integer>(set);
        Integer[] tmp = newList.toArray(new Integer[0]);
        Arrays.sort(tmp);*/
        Integer[] tmp = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        int[] ans = Arrays.stream(tmp).mapToInt(i->i).toArray(); // mapToInt(Integer::intValue)
        return ans;
        /* stream 없이 for문 사용하기
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num: arr) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = set.pollFirst();
        }
        return result;*/
    }
}