#include <iostream>
#include <cstdio>
#include <algorithm>
#include <set>
using namespace std;
int n, m, x;
set<int> s;
set<int>::iterator iter;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    cin>>n;
    for (int i=0; i<n; i++) {
        cin>>x;
        s.insert(x);
    }
    cin>>m;
    while (m--) {
        cin>>x;
        iter = s.find(x);
        if (iter != s.end()) cout<<1<<"\n";
        else cout<<0<<"\n";
    }

    printf("\n");
    return 0;
}