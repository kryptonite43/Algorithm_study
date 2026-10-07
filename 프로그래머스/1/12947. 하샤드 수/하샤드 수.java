class Solution {
    public boolean solution(int x) {
        int org = x;
        int sum = 0;
        while (x>0) {
            int tmp = x%10;
            sum += tmp;
            x /= 10;
        }
        
        return (org%sum==0);
    }
}