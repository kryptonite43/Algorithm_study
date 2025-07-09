#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
// 인접 리스트로 풀 것임

vector<vector<int>> adj(100010);
vector<pair<int,int>> family;
bool visited[100010] = {0};

void dfs(int cur) {
    visited[cur]=1;
    for (int child: adj[cur]) {
        if (!visited[child]) {
            family.push_back({child, cur});
            dfs(child);
        }
    }
}

int main() {
    int n;
    cin>>n;
    for (int i=0; i<n-1; i++) {
        int a,b;
        cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    dfs(1);
    sort(family.begin(), family.end());

    for (int i=0; i<family.size(); i++) {
        cout<<family[i].second<<"\n";
    }
    printf("\n");
    return 0;
}