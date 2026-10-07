import java.util.*;


class Solution {
    public int solution(int[] nums) {
        int n = nums.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int x: nums) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        
        if (n<=map.size())
            return n;
        else 
            return map.size();
    }
}