#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n, num = 1, sum=0;
    vector<int> v;
    scanf("%d", &n);
    for (int i=0; i<n; i++){
        int a;
        scanf("%d", &a);
        v.push_back(a);    
    }
    sort(v.begin(), v.end());
    while (true) {
         auto it = find(v.begin(), v.end(), num);
         if (it == v.end()) {
            //printf("%d 없음, 검사 시작\nsum: ", num);
            int index = upper_bound(v.begin(), v.end(), num)-v.begin();
            for (int i=0; i<index; i++){
                sum+=v[i];
                //printf("%d, ", sum);
            }
            printf("\n");
            if (sum < num) {
                //printf("결론: sum이 num보다 작음. sum: %d, num: %d\n",sum,num);
                sum = 0;
                break;
            }
            sum = 0;  
        }
        num++; 
    }

    printf("\n\n");
    return 0;
}