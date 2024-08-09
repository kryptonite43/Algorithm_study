#include <iostream>
#include <cstdio>
#include <algorithm>
#include <numeric>
using namespace std;
typedef long long ll;

ll n, m;
ll budgets[10010];

ll findMaxBudget(int target, int start, int end) {
    ll mid, sum = 0, ans = 0, maxbudget = 0;
    ll originalsum = accumulate(budgets, budgets+n, 0);

    while (start <= end) {
        mid = (start+end)/2; // 지정 상한액

        if (originalsum <= target) {
            return budgets[n-1];
        }
        else { // 예산 초과의 경우: originalsum > target
            ll stindex = upper_bound(budgets, budgets+n, mid)-budgets;
            sum = accumulate(budgets, budgets+stindex, 0) + mid * (n-stindex);
            if (sum <= target) { // 예산 안에 들어옴: 1차 만족
                if (ans<sum) { // ans 업데이트, maxbud 저장
                    maxbudget = mid;
                    ans = sum;
                }
                if (sum == target) return mid;
                else start = mid+1;
            }
            else { // sum > target: mid로 낮췄는데도 예산 초과 
                   // -> 상한액 더 줄여야함
                end = mid-1;
            }
        }
    }
    return maxbudget;
}

int main() {
    cin.tie(0); cout.tie(0);
    ios_base::sync_with_stdio(false);
    cin>>n;
    for (int i=0; i<n; i++) {
        cin>>budgets[i];
    }
    cin>>m;

    sort(budgets, budgets+n);
    cout<<findMaxBudget(m, 0, budgets[n-1]);
    return 0;
}