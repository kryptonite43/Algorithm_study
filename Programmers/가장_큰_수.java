import java.util.*;
import java.util.stream.Collectors;

public class 가장_큰_수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(solution(new int[]{89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        String[] res = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(res, (o1, o2) -> {
                    if (o1.contains("0") && !o2.contains("0")) {
                        return 1;
                    } else if (!o1.contains("0") && o2.contains("0")) {
                        return -1;
                    } else {
                        return -o1.compareTo(o2); // o1>o2면 1, o1<o2면 -1, 같으면 0
                    }
                }
        );
        List<String> ans = Arrays.stream(res).collect(Collectors.toList());
        List<String> check = Arrays.stream(res).distinct().collect(Collectors.toList());
        if (check.size() == 1 && Integer.parseInt(check.get(0))==0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(ans.stream().map(Object::toString).collect(Collectors.joining("")));

        return sb.toString();
    }
}
