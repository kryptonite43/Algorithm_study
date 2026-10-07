import java.util.*;

class Solution {
    public int[] solution(int n, int[] stages) {
        double[][] failRate = new double[n+1][2];
        int[] counti = new int[n+2];
        int[] presum = new int[n+2];
        int[] answer = new int[n];
        int index = 0;
        
        for (int i=0; i<stages.length; i++) { 
            counti[stages[i]]++;
        }
        
        presum[n+1] = counti[n+1];
        for (int i=n; i>0; i--) {
            presum[i] = counti[i] + presum[i+1];
        }

        for (int i=1; i<=n; i++) { 
            if (counti[i]==0) {
                failRate[i][0] = 0;
            }
            else {
                failRate[i][0] = (double)counti[i]/presum[i];
            }
            failRate[i][1] = i;
        }


        Arrays.sort(failRate, (o1, o2) -> {
            if (o1[0] != o2[0]) { 
                return Double.compare(o2[0], o1[0]);
            } else { 
                return (int) (o1[1]- o2[1]);
            }
        });

        for (int i=0; i<failRate.length; i++) {
            if (Double.compare(failRate[i][1], 0.0) == 0) {continue;}
            answer[index++] = (int) failRate[i][1];
        }

        return answer;
    }
}