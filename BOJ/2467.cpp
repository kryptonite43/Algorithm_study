#include <iostream>
#include <cstdio>
#include <stdlib.h>
#include <algorithm>
using namespace std;
typedef long long ll;

ll n, liq[100010];

ll findTwoLiq(ll start, ll end) {
    ll sum, a, b, ressum = 2000000001, resa = 0, resb = 0;
    while (start < end) {
        a = liq[start];
        b = liq[end];
        sum = a+b;
        
        if (sum == 0) {
            cout<<a<<" "<<b;
            return 0;
        }
        else { // abs(sum) > 0
            if (ressum > abs(sum)) { // sum 최소 상태, res 값 업데이트
                ressum = abs(sum);
                resa = a, resb = b;
            }
            if (sum < 0) {
                start++;
            }
            else {
                end--;
            }
        }
    }
    // 0인 값을 발견하지 못했을 때
    cout<<resa<<" "<<resb;
    return 0;
}

int main() {
    cin.tie(0); cout.tie(0);
    ios_base::sync_with_stdio(false);

    cin>>n;
    for (int i=0; i<n; i++) {
        cin>>liq[i];
    }

    findTwoLiq(0, n-1);
    return 0;
}