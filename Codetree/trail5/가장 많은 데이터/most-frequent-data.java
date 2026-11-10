import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s,0)+1);
        }
        
        System.out.println(Collections.max(map.values()));
    }
}
/*
n 최대 10만, 문자열 길이 50
문자열 등장 횟수를 hashmap에 <문자열, 횟수> 로 기록한다.
*/