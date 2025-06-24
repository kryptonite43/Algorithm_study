import java.util.*;

public class 큰_수_만들기 {

    public static void main(String[] args) {
        System.out.println(solution("320137000008",8));
    }
    /*number	    k	return
    "1924"	        2	"94"
    "1231234"	    3	"3234"
    "4177252841"	4	"775841"*/

    private static String solution(String number, int k) {
        int len = number.length();
        char[] numchr = number.toCharArray();
        int[] num = new int[len];
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<len; i++) {
            num[i] = numchr[i]-'0';
        }
        //System.out.println(Arrays.toString(num));


        int idx = 0; // 현재 탐색해야하는 첫 부분 (max 바로 뒤)
        for (int i=0; i<len-k; i++) {
            int max = 0;
            //System.out.printf("%d~%d 인덱스 범위 체크. ", idx, i+k);
            for (int j=idx; j<=i+k; j++) { // 0,1,2,3,4 max 체크 -> num[2]=7이 max. => 그 다음 3~5 체크 해야됨
                if (max < num[j]) {
                    max = num[j];
                    idx = j+1;
                }
            }
            //System.out.println("현재 구간 max idx: "+(idx-1));
            sb.append(max);
            //System.out.println("현재: " +sb);
        }
        return sb.toString();
        /*int strlen = number.length();
        char[] num = new char[strlen+2];
        number = "0"+number+"0";
        num = number.toCharArray();
        ArrayDeque<Character> ans = new ArrayDeque<>();

        for (int i=0; i<strlen; i++) { // 초기값 설정
            ans.add(num[i]);
        }


        // 내려갔다 올라가는 구간 숫자를 삭제
        // 시작 수는 제일 커야함
        for (int i=k-1; i>=0; i--) { // k번 반복: 한 번 돌 때마다 숫자 하나 제거
            // 6번째 원소 들어왔을 때, 뭐가 나가야하나?
            System.out.println("현재 arr: "+ans);
            for (int j=1; j<strlen-i; j++) { // 앞부분에 대해서
                if (num[j-1]>num[j] && num[j+1]>num[j]) { // j가 골짜기

                }
                else if ()
            }
            System.out.println("::변경: "+Arrays.toString(num));
        }*/

    }
}

