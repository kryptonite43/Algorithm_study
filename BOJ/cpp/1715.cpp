#include <iostream>
#include <cstdio>
#include <algorithm>
#include <queue>
using namespace std;

int main() {
    int n, first, second, sum=0;
    priority_queue<int, vector<int>, greater<int>> pq; // 오름차순. 최소부터 출력됨

    cin>>n;
    for (int i=0; i<n; i++) {
        int x;
        cin>>x;
        pq.push(x);
    }

    while (pq.size()!=1) {
        first = pq.top();
        pq.pop();
        second = pq.top();
        pq.pop();
        sum += (first+second);
        pq.push(first + second);
    }
    cout<<sum<<"\n";
    return 0;
}