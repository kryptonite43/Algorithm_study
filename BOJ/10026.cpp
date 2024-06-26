#include <iostream>
#include <cstdio>
using namespace std;

int n, normal = 0, blind = 0;
string str;
int adj[101][101];
bool visited[101][101] = {0};
int mv[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
// R=1 G=2 B=0
void dfs(int curx, int cury, int color, bool isBlind){
    visited[curx][cury] = 1;

    for (int i=0; i<4; i++) {
        int nextx = curx + mv[i][0];
        int nexty = cury + mv[i][1];

        if (nextx>=0 && nextx < n && nexty>=0 && nexty<n) { // 그리드 범위 안의 값
            if (isBlind) { // R=G로 판단.
                if (visited[nextx][nexty]==0 && (!(!adj[nextx][nexty])== color)) {
                    dfs(nextx,nexty,color,isBlind);
                }
                visited[nextx][nexty]=1;
            }
            else {
                if (visited[nextx][nexty]==0 && adj[nextx][nexty]==color) {
                    dfs(nextx,nexty,color,isBlind);
                }
                visited[nextx][nexty]=1;
            }
        }
    }
}

pair<int,int> allVisitCheck(int color, bool isBlind) {
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            if (isBlind) {
                if (visited[i][j]==0 && (!(!adj[i][j])==color)){
                    return make_pair(i,j);
                }
            }
            else {
                if (visited[i][j]==0 && adj[i][j]==color){
                    return make_pair(i,j);
                }
            }
        }
    }
    return make_pair(n,n);
}

int main() {
    cin>>n;
    for (int i=0; i<n; i++) {
        cin>>str;
        for (int j=0; j<n; j++) {
            char c = str[j];
            // R=1 G=2 B=0
            switch(c) {
                case 'R':
                    adj[i][j] = 1;
                    break;
                case 'G':
                    adj[i][j] = 2;
                    break;
                case 'B':
                    adj[i][j] = 0;
                    break;
            }
        }
    }
    // 1. 일반 사람의 경우
    for (int t=0; t<3; t++) {
        pair<int,int> check = allVisitCheck(t,0);
        while (check.first != n || check.second != n) {
            int x = check.first;
            int y = check.second;
            dfs(x, y, t, 0);
            normal++;
            check = allVisitCheck(t,0);
        }
        fill(&visited[0][0], &visited[100][101], 0);
    }

    // 2. 적록색약의 경우
    for (int t=0; t<2; t++) {
        pair<int,int> check = allVisitCheck(t,1);
        while (check.first != n || check.second != n) {
            int x = check.first;
            int y = check.second;
            dfs(x, y, t, 1);
            blind++;
            check = allVisitCheck(t,1);
        }
        
        fill(&visited[0][0], &visited[100][101], 0);
    }
 
    printf("%d %d\n",normal, blind);

    return 0;
}