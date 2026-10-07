import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n]; // 왼쪽 끝점
        int[] x2 = new int[n]; // 오른쪽 끝점

        int[] arr = new int[200];
        
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        
        for (int i=0; i<n; i++) {
            for (int j=x1[i]+100; j<x2[i]+100; j++) {
                arr[j]++;
            }
        }

        System.out.println(Arrays.stream(arr).max().getAsInt());
    }
}