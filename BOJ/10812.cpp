#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;
int arr[101];

int main() {
    int n, m, i, j, k;
    cin>>n>>m;
    for (int a=0; a<=n; a++) {
        arr[a]=a;
    }
    for (int a=0; a<m; a++) {
        int tmp[101] = {0};
        cin>>i>>j>>k;
        copy(arr+k,arr+j+1,tmp+i); // mid~end
        copy(arr+i,arr+k,tmp+i+j-k+1); // begin~ . 앞구간 개수 j-k+1개임. 
        copy(tmp+i,tmp+j+1,arr+i); // tmp를 arr에 옮기기
    }
    for (int b = 1; b <= n; b++) {
        cout << arr[b] << " ";
    }
    printf("\n");
    return 0;
}