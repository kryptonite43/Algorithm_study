#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;

int n, l, r, cnt=0, group=1;
// bool visited[51][51];
int pop[51][51];
int comp[51][51];
int dx[4] = {0,0,-1,1};
int dy[4] = {1,-1,0,0};
vector<vector<pair<int, pair<int,int>>>> v;


pair<int,int> visitCheck() {
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            if (comp[i][j] == 0){
                return {i,j};
            }
        }
    }
    return {n,n};
}

/* pair<int,int> assoCheck(int checknum) {
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            if (comp[i][j] == checknum){
                return {i,j};
            }
        }
    }
    return {n,n};
} */

bool dfs(int a, int b, int grp, bool move) {
    comp[a][b] = grp; // (a,b) 나라의 연합을 찾는 것. 이때의 그룹번호 grp
    
    for (int i=0; i<4; i++) {
        int nx = a+dx[i];
        int ny = b+dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
        int dist = abs(pop[a][b]-pop[nx][ny]);
        if (comp[nx][ny]==0 && l<=dist && dist<=r) {
            //comp[nx][ny] = grp; // 연합으로 합친다
            move = true;
            dfs(nx,ny,grp, move);
        }
    }
    return move;
}

int main() {
    /*cin.tie(0); cout.tie(0);
    ios_base::sync_with_stdio(false);*/

    cin>>n>>l>>r;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            cin>>pop[i][j];
        }
    }

    while (true) { // 하루 동안 벌어지는 일
        fill(&comp[0][0], &comp[50][51], 0);
        //fill(&visited[0][0], &visited[50][51], 0);
        group = 1;

        // 1. 연합 구하기
        int a = 0; int b = 0; bool mv = false;
        for( ; ; group++) {
            mv = dfs(a, b, group, false) || mv;
            
            pair<int,int> start = visitCheck();
            a = start.first;
            b = start.second;
            if (a==n && b==n) {// 모두 방문하였음
                if (!mv) { // 연합이 아예 없었으면
                    cout<<cnt;
                    return 0;
                }
                break;
            } 
                
        }
        // 완성된 comp 배열 출력
/*         for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                cout<<comp[i][j]<<" ";
            }
            cout<<"\n";
        }
        cout<<"=============\n"; */

        // 2. 연합끼리 인구 이동하기
        /* for (int i=0; i<n; i++) {
            vector<pair<int, pair<int,int>>> tmp;
            for (int j=0; j<n; j++) {
                tmp.push_back({comp[i][j],{i,j}});
            }
            v.push_back(tmp);
        } */
        
        for (int k=1; k<=group; k++) {
            vector<pair<int, pair<int,int>>> tmp;
            for (int i=0; i<n; i++) { // comp 순회하며 vector에 넣는다
                for (int j=0; j<n; j++) {
                    if (comp[i][j]==k) {
                        tmp.push_back({comp[i][j],{i,j}});
                    }
                    else {
                        continue;
                    }
                }
            }
            v.push_back(tmp);
        }

        //sort(v.begin(), v.end());
 /*        for (int i=0; i<v.size(); i++) {
            for (int j=0; j<v[i].size(); j++) {
                cout<<v[i][j].first<<" "<< v[i][j].second.first<<" "<<v[i][j].second.second<<"      ";
            }
            cout<<"\n";
        }
        cout<<"-------------\n"; */
        //int cur = v[0][0];
        int sum = 0;
        for (int i=0; i<v.size(); i++) {
            for (int j=0; j<v[i].size(); j++) {
                int x = v[i][j].second.first;
                int y = v[i][j].second.second;
                sum += pop[x][y];
            }
            int newpop = sum/v[i].size();
            for (int j=0; j<v[i].size(); j++) {
                pair<int,int> indp = v[i][j].second; // {i,j}
                pop[indp.first][indp.second] = newpop;
            }
            sum=0;
        }

        // 3. 하루에 할 일 모두 끝났을 때: 
        cnt++; 
    }
    cout<<cnt;
    return 0;
}