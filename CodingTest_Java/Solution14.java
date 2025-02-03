import java.util.*;
import java.util.stream.Collectors;

public class Solution14 {

    public static void main(String[] args) {
        System.out.println(solution(12,6, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
    }
/*
* n	k	cmd	result
8	2	["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]	"OOOOXOOO"
8	2	["D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"]	"OOXOXOOO"
* */
    private static String solution(int n, int k, String[] cmd) {
        int select = k;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<int[]> deleted = new Stack<>();

        for (int i=0; i<n; i++) {
            list.add(i);
        }

        for (String s: cmd) {
            switch(s.charAt(0)) {
                case 'U' -> {
                    String[] c = s.split(" ");
                    int x = Integer.parseInt(c[1]);
                    int mv = Character.getNumericValue(x);
                    select -= mv;
                }
                case 'D' -> {
                    String[] c = s.split(" ");
                    int x = Integer.parseInt(c[1]);
                    int mv = Character.getNumericValue(x);
                    select += mv;
                }
                case 'C' -> {
                    int num = list.get(select);
                    deleted.push(new int[]{num,select});
                    list.remove(select);
                    if (select == list.size()) {
                        select -= 1;
                    }
                }
                case 'Z' -> {
                    int[] alive = deleted.pop();
                    int cur = list.get(select);
                    list.add(alive[1], alive[0]);
                    if (alive[0] < cur) { // 현재 select 앞쪽에 끼워짐 -> select +1 해야 함
                        select += 1;
                    }
                }
            }
            System.out.println("현재 명령어: "+s);
            System.out.println("현재 select: "+ select);
            System.out.println("현재 표: " + list.toString()+"\n");
        }

        String[] ans = new String[n];
        Arrays.fill(ans, "X");

        for (int i=0; i<list.size(); i++) {
            ans[list.get(i)] = "O";
        }

        StringBuilder sb = new StringBuilder(Arrays.stream(ans).collect(Collectors.joining("")));

        return sb.toString();
    }
}