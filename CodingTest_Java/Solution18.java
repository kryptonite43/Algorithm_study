import java.util.*;

public class Solution18 {

    public static void main(String[] args) {

        //System.out.println(solution(new int[]{1,2,3,4,8},6));
        System.out.println(solution(new int[]{2,3,5,9},13));
    }

    private static boolean solution(int[] arr, int target) {
        List<Integer> arrList = Arrays.stream(arr).boxed().toList();
        HashSet<Integer> set = new HashSet<>(arrList);

        for (int x: arr) {
            if (x*2 == target) {
                continue;
            }
            if (set.contains(target-x)) {
                return true;
            }
        }
        return false;
    }
}