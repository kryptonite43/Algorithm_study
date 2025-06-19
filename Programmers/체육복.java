import java.util.ArrayList;
import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{4,5},new int[]{5}));
    }
    /*  n	lost	reserve	    return
        5	[2, 4]	[1, 3, 5]	5
        5	[2, 4]	[3]	        4
        3	[3]	    [1]	        2
    * */
    private static int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> students = new ArrayList<>(n+1);
        ArrayList<Integer> finalLost = new ArrayList<>();
        for (int i=0; i<n+1; i++) {
            students.add(0);
        }

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int x: reserve) { // 여분 체육복 체크
            students.set(x-1, 2);
        }
        for(int x: lost){ // 여분을 도둑맞은 학생 미리 처리
            if (students.get(x-1)==2) {
                students.set(x-1, 1);
            }
        }

        for (int x: lost) {
            if (students.get(x-1)==1) { //여분을 도둑맞은 학생임
                continue;
            }
            if (x>1 && students.get(x-2)==2) { // 앞에 여분 체육복 가진 학생 있으면
                students.set(x-2, 1);
            }
            else if (students.get(x)==2) { // 뒤에 여분 체육복 가진 학생 있으면
                students.set(x, 1);
            }
            else { // 못 받음
                finalLost.add(x);
            }
        }
        return n-finalLost.size();
    }

}
