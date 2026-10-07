import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        
        int[] arr = new int[101];
        Arrays.fill(arr, 0);

        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }

        for (int i=0; i<n; i++) {
            for (int j=start[i]; j<=end[i]; j++) {
                arr[j]++;
            }
        }

        System.out.println(Arrays.stream(arr).max().getAsInt());

        /*
    
        점이 겹치는거 -> 그냥 점 기준으로 세면 될듯?
        */
    }
}