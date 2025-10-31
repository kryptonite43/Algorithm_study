import java.util.*;

public class PCCE09_지폐_접기 {

    public static void main(String[] args) {
        solution(new int[]{30,15}, new int[]{26,17}); // 1
    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int bmin = Math.min(bill[0], bill[1]);
        int bmax = Math.max(bill[0], bill[1]);
        int wmin = Math.min(wallet[0], wallet[1]);
        int wmax = Math.max(wallet[0], wallet[1]);
        while (bmin>wmin || bmax>wmax) {
            if (bill[0]>bill[1])
                bill[0] /= 2;
            else
                bill[1] /= 2;
            answer++;
            bmin = Math.min(bill[0], bill[1]);
            bmax = Math.max(bill[0], bill[1]);
            wmin = Math.min(wallet[0], wallet[1]);
            wmax = Math.max(wallet[0], wallet[1]);
        }
        return answer;
    }
}

