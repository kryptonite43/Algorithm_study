import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        List<String> nameList = Arrays.stream(name).collect(Collectors.toList());
        
        for (int i=0; i<photo.length; i++) {
            String[] curPhoto = photo[i];
            int sum = 0;
            for (int j=0; j<curPhoto.length; j++) {
                if (nameList.contains(curPhoto[j])) {
                    int indx = nameList.indexOf(curPhoto[j]);
                    sum += yearning[indx];
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}