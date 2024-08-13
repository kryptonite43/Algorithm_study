#include <iostream>
#include <cstdio>
#include <numeric>
#include <cmath>
#include <algorithm>
using namespace std;

int n,m;
int lec[100010];
// maxsum: 현재 mid에서의 블루레이 실제 크기
// ressum: 최적 mid에서의 블루레이 실제 크기
int findMinBluray(int start, int end) { 
    int sum = 0, ressum = end, maxsum, cnt;

    while (start <= end) {
        int mid = (start+end)/2; // 블루레이 크기 기준
        maxsum = 0, cnt = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            if (sum + lec[i] > mid) {
                maxsum = max(sum, maxsum);
                sum = lec[i];
                cnt++;
            }
            else { // sum + lec[i] <= mid
                sum += lec[i];
            }
            if (i == n - 1) {
                maxsum = max(sum, maxsum);
                cnt++;
            }
        }
        if (cnt > m) { // 블루레이 개수 초과: 기준 올려서 덜 쪼개야 함
            start = mid+1;
        }
        else { // 블루레이 개수 충족/미달: 기준 내려 더 많이 쪼갤 수 있나?
            ressum = min(ressum, maxsum);
            end = mid-1;
        }
    }
    cout<<ressum;
    return 0;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);

    cin>>n>>m;
    int fsum = 0;
    for (int i=0; i<n; i++) {
        cin>>lec[i];
        fsum += lec[i];
    }
    findMinBluray(1, fsum);
    return 0;
}