#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int binarySearch(vector<int>& arr, int target, int curmax, int start, int end) {
    if (start > end) return curmax;
    int mid = (start + end) / 2;
    long long int sum = 0;

    int begind = lower_bound(arr.begin(), arr.end(), mid) - arr.begin(); // 오름차순 정렬되었을 때, 같거나 큰 첫번째 값 인덱스를 리턴
    for (int i=begind; i<arr.size(); i++) {
        sum += (arr[i]-mid);
    }
    curmax = mid;
    if (sum == target) return mid;
    else if (sum > target) return binarySearch(arr, target, curmax, mid+1, end);
    else return binarySearch(arr, target, curmax, start, mid-1);
}

int main() {
    int n,m;
    vector<int> tteok;

    cin>>n>>m;
    tteok.push_back(0);
    for (int i=0; i<n; i++) {
        int x;
        cin>>x;
        tteok.push_back(x);
    }

    sort(tteok.begin(), tteok.end());
    cout<<binarySearch(tteok, m, -1, tteok[0], tteok[n]);

    printf("\n");
    return 0;
}