import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] arr = new int[n+1];
        
        Arrays.fill(arr, 0);

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int j=a; j<=b; j++) {
                arr[j]++;
            }
        }
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }
}