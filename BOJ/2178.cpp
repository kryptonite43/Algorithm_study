#include <iostream>
#include <cstdio>
#include <cstring>
#include <queue>
#include <cmath>
using namespace std;

int n,m,leng;
int mv[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
int adj[101][101];
bool visited[101][101] = {0};
string str;

int bfs(pair<int,int> start) {
    queue<pair<pair<int,int>,int>> q; // 좌표 {x,y}, 현재 경로 길이 length pair
    leng = 999999999;
    q.push({start, 1});
    visited[start.first][start.second] = 1;

    while (!q.empty()) {
        int curx = q.front().first.first;
        int cury  = q.front().first.second;
        int curlen = q.front().second;

        q.pop();
        for (int i=0; i<4; i++) {
            int nextx = curx + mv[i][0];
            int nexty = cury + mv[i][1];

            if (nextx>=0 && nextx<n && nexty>=0 && nexty<m
            && visited[nextx][nexty]==0 && adj[nextx][nexty]==1) { 
                // 방문 안했고 미로범위 안의 이동할 수 있는 칸인 경우
                q.push({{nextx,nexty},curlen+1});
                visited[nextx][nexty] = 1;
            }
            else if (nextx>=0 && nextx<n && nexty>=0 && nexty<m) {
                visited[nextx][nexty] = 1;
            }
        }
        if (curx == n-1 && cury == m-1) { // 도착
            leng = curlen;
            return leng;
        }
    }
    return leng;
}

int main() {
    cin>>n>>m;
    for (int i=0; i<n; i++) {
        cin>>str;
        for (int j=0; j<m; j++) {
            int x = str[j]-'0';
            adj[i][j] = x;
        }
    }

    bfs({0,0});
    
    printf("%d\n",leng);
    return 0;
}