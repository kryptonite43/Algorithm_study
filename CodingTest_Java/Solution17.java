import java.util.*;


public class Solution17 {

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"},new String[]{"i", "want", "to", "drink", "water"}));
    }
/*    cards1	                cards2	        goal	                                result
      ["i", "drink", "water"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"Yes"
      ["i", "water", "drink"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"No"*/
    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> q1 = new ArrayDeque<>();
        ArrayDeque<String> q2 = new ArrayDeque<>();

        for (String s : cards1) q1.addLast(s);
        for (String s : cards2) q2.addLast(s);

        for (String s : goal) {
            if (s.equals(q1.peek()))
                q1.pollFirst();
            else if (s.equals(q2.peek()))
                q2.pollFirst();
            else
                return "No";
        }
        return "Yes";
    }
}