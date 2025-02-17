import java.util.*;

public class Solution18 {

    public static void main(String[] args) {

        //System.out.println(solution(new int[]{1,2,3,4,8},6));
        System.out.println(solution(new int[]{2,3,5,9},10));
    }

    private static boolean solution(int[] arr, int target) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int x: arr) {
            h.put(x, target-x);
        }
        for (int j : arr) {
            int val = h.get(j);
            h.remove(j);
            if (h.containsKey(val))
                return true;
            else
                h.put(j, val);
        }
        return false;
    }
}