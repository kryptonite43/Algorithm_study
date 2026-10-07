import java.util.*;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        /*Arrays.sort(phone_book);
        int n = phone_book.length;
        for (int i = 0; i < n - 1; i++) {
            String a = phone_book[i];
            String b = phone_book[i + 1];
            if (a.length() < b.length() && b.startsWith(a)) {
                return false;
            }
        }
        return true;*/
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i=0; i<phone_book.length; i++) {
            // 전화번호 길이만큼 순회
            for (int j=0; j<phone_book[j].length(); j++) {
                // 해당 전화번호의 접두어를 key로 가진 경우
                if (map.containsKey(phone_book[i].substring(0,j)))
                    return false;
            }
        }
        return true;
    }
}

