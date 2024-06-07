#include <iostream>
#include <cstdio>
#include <vector>
using namespace std;

int main() {
    int n, x, sum1=0, sum2=0;
    vector<int> v;
    cin>>n;
    while (n!=0) {
        x = n % 10; // 1의 자릿수부터 저장
        n = n / 10;
        v.push_back(x);
    }
    for (int i=0; i<v.size(); i++) {
        (i<v.size()/2)?sum1+=v[i]:sum2+=v[i];
    }
    if (sum1==sum2)
        printf("LUCKY\n");
    else
        printf("READY\n");

    printf("\n\n");
    return 0;
}