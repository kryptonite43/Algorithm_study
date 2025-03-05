import java.util.stream.*;
import java.util.*;


public class 폰켓몬 {
    public int solution(int[] nums) {
        /*int n = nums.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int x: nums) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        if (n<=map.size())
            return n;
        else
            return map.size();*/
        return Arrays.stream(nums).boxed().collect(
                Collectors.collectingAndThen(Collectors.toSet(), ph -> Integer.min(ph.size(), nums.length/2))
        );
    }
}