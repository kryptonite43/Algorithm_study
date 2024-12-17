
/** @noinspection NonAsciiCharacters*/
public class 배열의_평균값 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(solution(new int[]{89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}));
    }

    public static double solution(int[] numbers) {
        double answer = 0;
        for (int x: numbers) {
            answer += x;
        }
        return answer / numbers.length;
        /* stream 사용해서 한 줄에 끝내는 법
        return Arrays.stream(numbers).average().orElse(0);
        */
    }
}
