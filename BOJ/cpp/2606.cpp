#include <iostream>
#include <cstdio>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int>> adj(101);
bool visited[101] = {0};

int bfs(int start) {
    int cnt = 0;
    queue<int> q;
    q.push(start);
    visited[start] = 1;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        //cout<<"cur: "<<cur<<", ";
        for (int next: adj[cur]) {
            if (visited[next]==0) {
                q.push(next);
                //printf("%d 방문 완료\n", next);
                cnt++;
                visited[next] = 1;
            }
        }
    }
    return cnt;
}

int main() {
    int n, p, a, b;
    cin>>n;
    cin>>p;
    for (int i=0; i<p; i++) {
        cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    /* cout<<"시작\n";
    for (int i=0; i<n; i++) {
        for (int j=0; j<adj[i].size(); j++) {
            cout<<adj[i][j]<<" ";
        }
        cout<<"\n";
    }
 */
    cout<<bfs(1)<<"\n";
    return 0;
}