import java.util.*;
import java.util.stream.*;

public class 추억_점수 {

    public static void main(String[] args) {
            System.out.println(Arrays.toString(solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}} )));
        }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
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

