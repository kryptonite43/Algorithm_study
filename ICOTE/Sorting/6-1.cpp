// <2> 실전 문제 - 위에서 아래로
#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;

int main() {
    int n;
    int arr[510];
    cin>>n;
    for (int i=0; i<n; i++) {
        cin>>arr[i];
    }
    sort(arr, arr+n, greater<>());
    for (int i=0; i<n; i++) {
        cout<<arr[i]<<" ";
    }

    printf("\n\n");
    return 0;
}