#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

vector<vector<int>> adj(1010);
bool visitedd[1010] = {0};
vector<vector<int>> adjtmp(1010);
bool visitedb[1010] = {0};

void dfs(int cur) {
    visitedd[cur] = 1;

    cout << cur << " ";
    for (int i = 0; i < adj[cur].size(); i++) {
        int next = adj[cur][i];
        if (!visitedd[next])
            dfs(next);
    }  
}


void bfs(int start) {
    queue<int> q;
    q.push(start);
    visitedb[start]=1;
    cout<<start<<" ";

    while(!q.empty()) {
        int cur = q.front();
        q.pop();

        for (int next: adj[cur]) {
            if (!visitedb[next]) {
                q.push(next);
                visitedb[next]=1;
                cout<<next<<" ";
            }
        }
    }
}

int main() {
    int n,m,v,a,b;
    cin>>n>>m>>v;
    for (int i=0; i<m; i++) {
        cin>>a>>b;
        adjtmp[a].push_back(b);
        adjtmp[b].push_back(a);
    }
    adj = adjtmp;

    for (int i=0; i<=n; i++) {
        vector<int> tmp = adjtmp[i];
        sort(tmp.begin(), tmp.end());
        tmp.erase(unique(tmp.begin(),tmp.end()),tmp.end());
        adj[i] = tmp;
    }
    
    dfs(v);
    cout<<"\n";  
    bfs(v);

    return 0;
}