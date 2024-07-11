#include <iostream>
#include <cstdio>
#include <algorithm>
#include <numeric>
using namespace std;

int n, k;
int arrA[100010];
int arrB[100010];

int main() {
    cin>>n>>k;
    for (int i=0; i<n; i++) {
        cin>>arrA[i];
    }
    for (int i=0; i<n; i++) {
        cin>>arrB[i];
    }

    sort(arrA, arrA + n);
    sort(arrB, arrB + n, greater<int>());

    for (int i=0; i<k; i++) {
        if (arrA[i]<arrB[i]) 
            swap(arrA[i],arrB[i]);
        else 
            break;
    }

    cout<<accumulate(arrA, arrA+n, 0)<<"\n";
    return 0;
}