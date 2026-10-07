import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String[] res = Arrays.stream(numbers)
            .mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(res, (o1, o2)-> {
            String str1 = o1+o2;
            String str2 = o2+o1;
            return -str1.compareTo(str2);
        });
        
        List<String> ans = Arrays.stream(res).collect(Collectors.toList());
        List<String> check = Arrays.stream(res).distinct().collect(Collectors.toList());
        if (check.size() == 1 && Integer.parseInt(check.get(0))==0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(ans.stream().map(Object::toString).collect(Collectors.joining("")));
        
        return sb.toString();
    }
}