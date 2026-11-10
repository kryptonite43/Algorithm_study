import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int tdy = getDayCount(today);
        
        int[] tms = new int[26]; // tms[약관번호] = 유효기간(달)
        Arrays.fill(tms, 0);
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i=0; i<terms.length; i++) {
            String[] term = terms[i].split(" ");
            int ind = term[0].charAt(0)-'A'; // 약관 번호 char
            tms[ind] = Integer.parseInt(term[1]);
        }
        
        for (int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int day = getDayCount(privacy[0]);
            int t = privacy[1].charAt(0)-'A';
            day += 28*tms[t];
            
            if (day <= tdy) {
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static int getDayCount(String day) {
        String[] str = day.split("\\.");
        int yr = Integer.parseInt(str[0]);
        int mo = Integer.parseInt(str[1]);
        int da = Integer.parseInt(str[2]);
        
        return (yr-2000)*28*12+(mo-1)*28+da;
    }
}