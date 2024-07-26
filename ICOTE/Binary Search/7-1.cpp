// <2> 실전 문제 - 부품 찾기
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;

int binarySearch(vector<int>& arr, int target, int start, int end) {
    if (start>end) return -1;
    int mid = (start + end) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
    else return binarySearch(arr, target, mid + 1, end);
}

int main() {
    int n,m,x;
    vector<int> store, cust;

    cin>>n;
    for (int i=0; i<n; i++) {
        cin>>x;
        store.push_back(x);
    }
    cin>>m;
    for (int i=0; i<m; i++) {
        cin>>x;
        cust.push_back(x);
    }

    sort(store.begin(), store.end());
    for (int num: cust) {
        int res = binarySearch(store, num, 0, store.size()-1);
        if (res == -1) cout<<"no ";
        else cout<<"yes ";
    }
    printf("\n");
    return 0;
}