import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main1283 {
    public void solution() throws Exception {
        HashSet<Character> key = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String optionstr = br.readLine();
            String[] option = optionstr.split(" ");
            int optSize = option.length;
            boolean done = false;
            String answerstr = "";

            for (int j=0; j<optSize; j++) { // 단어 첫 글자 체크
                if (!key.contains(option[j].charAt(0))) {
                    key.add(option[j].charAt(0));
                    if (option[j].charAt(0)>='a')
                        key.add(Character.toUpperCase(option[j].charAt(0)));
                    else
                        key.add(Character.toLowerCase(option[j].charAt(0)));

                    option[j] = "["+option[j].charAt(0)+"]"+ option[j].substring(1);
                    done = true;
                    break;
                }
            }
            if (!done) { // 알파벳 전체 체크
                int wordsize = optionstr.length();
                for (int j=0; j<wordsize; j++) {
                    if (optionstr.charAt(j) == ' ') continue;
                    if (!key.contains(optionstr.charAt(j))) {
                        key.add(optionstr.charAt(j));
                        if (optionstr.charAt(j)>='a')
                            key.add(Character.toUpperCase(optionstr.charAt(j)));
                        else
                            key.add(Character.toLowerCase(optionstr.charAt(j)));
                        answerstr = optionstr.substring(0,j)+"["+optionstr.charAt(j)+"]"+optionstr.substring(j+1);
                        break;
                    }
                }
            }
            else {
                StringBuilder sb = new StringBuilder(Arrays.stream(option).map(Object::toString).collect(Collectors.joining(" ")));
                answerstr = sb.toString();
            }
            if (answerstr.equals("")) {
                answerstr = optionstr;
            }
            bw.write(answerstr);
            bw.newLine();
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main1283().solution();
    }
}
