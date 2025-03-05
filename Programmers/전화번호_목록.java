import java.util.*;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        int n = phone_book.length;
        for (int i = 0; i < n - 1; i++) {
            String a = phone_book[i];
            String b = phone_book[i + 1];
            if (a.length() < b.length() && b.startsWith(a)) {
                return false;
            }
        }
        return true;
    }
}

