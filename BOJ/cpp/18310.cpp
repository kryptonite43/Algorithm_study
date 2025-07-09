#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

long long mini= 20000000001;
long long sum = 0;

int main() {
    int n, ant=0, finant=0;
    int house[200010];
    
    cin>>n;
    for (int i=0; i<n; i++) {
        cin>>house[i];
    }
    sort(house, house+n);
    ant = (n+1)/2;
    if (n%2==0) { // 짝수인 경우 중간값 중 합이 최소인 것 비교해 골라야 함
        for (int i=0; i<2; i++) {
            for (int j=0; j<n; j++) {
                sum += abs(house[j]-house[ant-1]);
            }
            if (sum<mini) {
                mini = sum;
                finant = ant;
            }
            sum=0;
            ant++;
        }
    }
    else
        finant = ant;
    cout<<house[finant-1];
    return 0;
}