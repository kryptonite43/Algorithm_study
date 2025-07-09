#include <iostream>
#include <cstdio>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

struct Virus {
    int vnum; // 바이러스 번호 vnum
    int x; // 바이러스 위치 x,y
    int y;
};
int n, k, s, x, y;
int tube[210][210];
vector<Virus> v;
int mv[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};



bool compare(Virus a, Virus b) {
    return a.vnum < b.vnum; // 오름차순 정렬
}

void infection() {
    int vsize = v.size();
    for (int i=0; i<vsize; i++) {
        int curvnum = v[i].vnum;
        int curx = v[i].x;
        int cury = v[i].y;

        for (int j=0; j<4; j++) {
            int nextx = curx + mv[j][0];
            int nexty = cury + mv[j][1];

            if (nextx < 1 || nextx > n || nexty < 1 || nexty > n)
                continue;
            if (tube[nextx][nexty] == 0) {
                tube[nextx][nexty] = curvnum;
                v.push_back({curvnum, nextx, nexty});
            }
        }
    }
    v.erase(v.begin(), v.begin()+vsize);
}

int main() {
    cin.tie(0); cout.tie(0);
    ios_base::sync_with_stdio(false);
    
    cin>>n>>k;
    
    for (int i=1; i<=n; i++) {
        for (int j=1; j<=n; j++) {
            cin>>tube[i][j];
            if (tube[i][j]!= 0)
                v.push_back({tube[i][j],i,j});
        }
    }    
    cin>>s>>x>>y;
    
    for (int i=1; i<=s; i++) {
        sort(v.begin(), v.end(), compare);
        infection();
    }
    if (tube[x][y] != 0) 
        cout<<tube[x][y];
    else
        cout<<0;
    return 0;
}
