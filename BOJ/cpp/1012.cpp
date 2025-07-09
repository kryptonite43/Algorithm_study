#include <iostream>
#include <cstdio>
#include <vector>
#include <stack>
using namespace std;
/* Goal: ������Ʈ�� ���� ���ϱ�
1. ��ġ �Է¹޾� �迭 ä���
2. (0,0)���� Ž�� ����, st.push()
3. dfs�� Ž���ϰ�, visited �迭 ����� �湮 ����. �湮���� ����, ���� ������ ��� �湮�ϴ� ���
4. ���� Ž���� ������ ������Ʈ ���� 1�� ����
5. m-1, n-1���� Ž�� �� ������ ���� ������Ʈ ���� ���
6. ���ο� ���� �ޱ� ��, ����, adj �迭, visited �迭, component ���� ��� �ʱ�ȭ */

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
        //printf("���� st.top(): %d, %d\n",curx,cury);
        st.pop();
        for (int i=0; i<4; i++) {
            int nextx = curx+mv[i][0];
            int nexty = cury+mv[i][1];

            if ((nextx>=0 && nextx <m && nexty>=0 && nexty <n )&& 
            (visited[nextx][nexty] == 0) && (adj[nextx][nexty]==1)) { // ���� ���� ���̰�, �湮���� ���� ���߰� �ִٸ�
                st.push({nextx,nexty});
            }
            visited[curx][cury] = 1;
        }
    }
    cpnt++;
}

pair<int,int> allVisitCheck() { // �湮���� ���� ��尡 �ִ��� ã��
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
    for (int i=0; i<t; i++) { // �ϳ��� �׽�Ʈ ���̽�
        cin>>m>>n>>k;
        for (int j=0; j<k; j++) {// k���� ���� ��ġ �ľ� �Է°�
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