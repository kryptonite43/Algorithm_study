#include <iostream>
#include <cstdio>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;

int n=0, cnt=1;
int adj[26][26] = {0};
bool visited[26][26]= {0};
int mv[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
stack<pair<int,int>> st;
vector<int> res;

void dfs(pair<int,int> start) {
    st.push(start);
    visited[start.first][start.second] = 1;

    while(!st.empty()) {
        pair<int,int> tmp = st.top();
        int curx = tmp.first;
        int cury = tmp.second;
        st.pop();

        for (int i=0; i<4; i++) {
            int tmpx = curx+mv[i][0];
            int tmpy = cury+mv[i][1];

            if (tmpx>=0 && tmpx <n && tmpy>=0 && tmpy<n && 
            visited[tmpx][tmpy]==0 && adj[tmpx][tmpy]==1) {
                st.push({tmpx,tmpy});
                visited[tmpx][tmpy] = 1;
                cnt++;
            }
        }
    }
}

pair<int,int> allVisitCheck() {
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            if (adj[i][j]==1 && visited[i][j]==0) {
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
            int x;
            scanf("%1d",&x);
            adj[i][j] = x;
        }
    }


    pair<int,int> check = allVisitCheck();
    while (check.first != n || check.second != n) {
        dfs(check);
        res.push_back(cnt);
        cnt = 1;
        check = allVisitCheck();
    }

    sort(res.begin(), res.end());
    cout<<res.size()<<"\n";
    for (int a: res) {
        cout<<a<<"\n";
    }
    return 0;
}