#include <iostream>
#include <cstdio>
#include <vector>
#include <stack>
using namespace std;
/* Goal: 컴포넌트의 개수 구하기
1. 위치 입력받아 배열 채우고
2. (0,0)부터 탐색 시작, st.push()
3. dfs로 탐색하고, visited 배열 사용해 방문 저장. 방문하지 않음, 배추 있음의 경우 방문하는 방식
4. 만약 탐색이 끝나면 컴포넌트 개수 1씩 증가
5. m-1, n-1까지 탐색 다 끝나면 최종 컴포넌트 개수 출력
6. 새로운 테케 받기 전, 스택, adj 배열, visited 배열, component 변수 모두 초기화 */

int adj[51][51]={0};
bool visited[51][51]={0};
int cpnt = 0;
int t, m, n, k, x, y;
int mv[4][2] = {{1,0},{0,1},{-1,0},{0,-1}};
stack<pair<int,int>> st;

void dfs(pair<int,int> start) {
    st.push(start);
    visited[start.first][start.second] = 1;
    while (!st.empty()) {
        int curx = st.top().first;
        int cury = st.top().second;
        //printf("현재 st.top(): %d, %d\n",curx,cury);
        st.pop();
        for (int i=0; i<4; i++) {
            int nextx = curx+mv[i][0];
            int nexty = cury+mv[i][1];

            if ((nextx>=0 && nextx <m && nexty>=0 && nexty <n )&& 
            (visited[nextx][nexty] == 0) && (adj[nextx][nexty]==1)) { // 정상 범위 안이고, 방문하지 않은 배추가 있다면
                st.push({nextx,nexty});
            }
            visited[curx][cury] = 1;
        }
    }
    cpnt++;
}

pair<int,int> allVisitCheck() { // 방문하지 않은 노드가 있는지 찾기
    for (int i=0; i<m; i++) {
        for (int j=0; j<n; j++) {
            if (visited[i][j]==0 && adj[i][j]==1)
                return make_pair(i,j);
        }
    }
    return make_pair(m,n);
}

int main() {

    cin>>t;
    for (int i=0; i<t; i++) { // 하나의 테스트 케이스
        cin>>m>>n>>k;
        for (int j=0; j<k; j++) {// k줄의 배추 위치 파악 입력값
            cin>>x>>y;
            adj[x][y]=1;
        }
        pair<int,int> tmp = allVisitCheck();
        while ((tmp.first != m) && (tmp.second != n)) {
            dfs({tmp.first, tmp.second});
            tmp = allVisitCheck();
        }
        cout<<cpnt<<"\n";
        fill(&adj[0][0],&adj[50][51],0);
        fill(&visited[0][0],&visited[50][51],0);
        cpnt = 0;
        
    }    printf("\n\n");
    return 0;
}