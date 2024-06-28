// 음료수 얼려 먹기
#include <iostream>
#include <cstdio>
using namespace std;

int n,m, cnt=0;
int mv[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
int adj[1001][1001];
bool visited[1001][1001] = {0};
string str;

void dfs(int curx, int cury) {
    visited[curx][cury] = 1;

    for (int i=0; i<4; i++) {
        int nextx = curx + mv[i][0];
        int nexty = cury + mv[i][1];

        if (nextx>=0 && nextx < n && nexty >=0 && nexty < m
        && adj[nextx][nexty]==0 && visited[nextx][nexty]==0) {
            dfs(nextx,nexty);
        } 
    }
}

pair<int,int> allVisitCheck() {
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            if (visited[i][j]==0 && adj[i][j]==0) {
                return make_pair(i,j);
            }
        }
    }

    return make_pair(n,m);
}


int main() {
    cin>>n>>m;
    for(int i=0; i<n; i++) {
        cin>>str;
        for (int j=0; j<m; j++) {
            adj[i][j]=str[j]-'0';
        }
    }

    pair<int,int> check = allVisitCheck();
    while (check.first != n || check.second != m) {
        dfs(check.first, check.second);
        cnt++;
        check = allVisitCheck();
    }
    /* cout<<"완료\n";

    for(int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            cout<<adj[i][j]<<" ";
        }
        cout<<"\n";
    } */
   cout<<cnt<<endl;
    return 0;
}


