#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

int n;
int num[1000010] = {0};


int main() {
    cin>>n;
    for (int i=0; i<n; i++){
        cin>>num[i];
    }

    //quickSort(num, 0, n-1);
    sort(num,num+n);
    for (int i=0; i<n; i++) {
        cout<<num[i]<<"\n";
    }
    printf("\n");
    return 0;
}