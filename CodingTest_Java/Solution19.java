import java.util.*;

public class Solution19 {

    public static void main(String[] args) {

        //System.out.println(solution(new String[]{"leo", "kiki", "eden"},new String[]{"eden", "kiki"}));
        //System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"},new String[]{"stanko", "ana", "mislav"}));
        System.out.println(solution(new String[]{"d","a","c","a","b","a","b"},new String[]{"b","a","b","a","a","d"}));
    }
/*
* 입출력 예
participant	                                        completion	                                return
["leo", "kiki", "eden"]	                            ["eden", "kiki"]	                        "leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	            ["stanko", "ana", "mislav"]	                "mislav"
* */
    private static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i=0; i<completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        return participant[participant.length-1];
    }
}