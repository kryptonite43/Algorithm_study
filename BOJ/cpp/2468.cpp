#include <iostream>
#include <cstdio>
#include <cmath>
#include <vector>
using namespace std;

int n, h, maxih=0, res=0, maxires=0; // ���� ���� ���� h, �ִ� �������� maxih
// ���� ���
int adj[101][101];
bool visited[101][101]={0};
int mv[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};

void dfs(pair<int,int> start, int curh) {
    int curx = start.first;
    int cury = start.second;
    visited[curx][cury] = 1;

    for (int i=0; i<4; i++) {
        int nextx = curx + mv[i][0];
        int nexty = cury + mv[i][1];

        if (adj[nextx][nexty]>curh && visited[nextx][nexty] == 0 
        && nextx>=0 && nextx<n && nexty >=0 && nexty <n) {
            dfs({nextx,nexty}, curh);
        }
        else if (nextx>=0 && nextx<n && nexty >=0 && nexty <n)
            visited[nextx][nexty]=1;
    }

}

pair<int,int> allVisitCheck(int curh) {
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            if (visited[i][j]==0 && adj[i][j]>curh) { // ���� �Ѿ��µ� �Ȱ���
                return make_pair(i,j);
            }
        }
    }
    return make_pair(n,n);
}

int main() {
    cin>>n;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            cin>>adj[i][j];
            maxih = max(maxih, adj[i][j]);
        }
    }

    for (h=0; h<=maxih; h++) { // ���� ���� 1�� �ø��� �ϳ��� ��� ����غ���
        pair<int,int> check = allVisitCheck(h);
        while (check.first != n || check.second != n) {
            dfs({check.first,check.second}, h);
            check = allVisitCheck(h);
            res++;
        }
        maxires = max(maxires, res);
        res = 0;
        fill(&visited[0][0],&visited[100][101],0);
    }

    printf("%d\n",maxires);
    return 0;
}