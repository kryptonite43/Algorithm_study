import java.util.*;

public class Solution07 {
    public static void main(String[] args) {

        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }
    static HashMap<Character, int[]> location = new HashMap<>();
    static HashSet<String> visited = new HashSet<>();

    private static int solution(String dirs) {
        int curx = 5, cury = 5, nx, ny;

        initLocation();
        for (int i=0; i<dirs.length(); i++) {
            char curloc = dirs.charAt(i);
            int[] moveloc = location.get(curloc);
            nx = curx + moveloc[0];
            ny = cury + moveloc[1];

            if (checkValid(nx, ny)) { // 범위 내의 좌표
                visited.add(curx+" "+cury+" "+nx+" "+ny);
                visited.add(nx+" "+ny+" "+curx+" "+cury);
                curx = nx;
                cury = ny;
            }
        }
        return visited.size()/2;
    }

    private static boolean checkValid(int x, int y) {
        return x>=0 && x<11 && y>=0 && y<11;
    }
    private static void initLocation() {
        location.put('L',new int[]{-1,0});
        location.put('R',new int[]{1,0});
        location.put('U',new int[]{0,1});
        location.put('D',new int[]{0,-1});
    }
}