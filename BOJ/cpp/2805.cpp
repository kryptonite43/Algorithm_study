#include <iostream>
#include <cstdio>
#include <algorithm>
#include <numeric>
#include <cmath>
using namespace std;

long long n, m;
long long trees[1000010];

int findCutHeight(long long target, long long start, long long end) {
    long long mid, ans = 0;
    long long sum=0;
    while (start<=end) {
        mid = (start+end)/2;
        long long stindex = lower_bound(trees, trees+n, mid)-trees;
        sum = (long long)accumulate(trees+stindex, trees+n, (long long)0)-mid*(n-stindex);

        if (sum >= target) {
            ans = max(ans, mid);
            if (sum == target) return mid;
            else start = mid + 1;
        }
        else 
            end = mid-1;
    }
    return ans;
}

int main() {
    cin.tie(0); cout.tie(0);
    ios_base::sync_with_stdio(false);

    cin>>n>>m;
    for (int i=0; i<n; i++) {
        cin>>trees[i];
    }
    sort(trees, trees+n);
    long long maxi = trees[max_element(trees, trees+n)-trees];
    cout<<findCutHeight(m, 0, maxi);
    return 0;
}