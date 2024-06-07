#include <iostream>
#include <cstdio>
#include <vector>
using namespace std;

int main() {
    int n,m,a,b,d, td, ta, tb, cnt=1, time=0;
    int map[50][50], check[50][50];
    vector<pair<int,int>> left = {{-1,0},{0,1},{1,0},{0,-1}};
    vector<pair<int,int>> back = {{1,0},{0,-1},{-1,0},{0,1}};
    cin>>n>>m;
    cin>>a>>b>>d;
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            cin>>map[i][j];
        }
    }

    check[a][b]=1;
    while (1) {
        d = (d+3)%4; // 탐색할 방향 (왼쪽 회전의 값)
        ta = a+left[d].first;
        tb = b+left[d].second;
        //printf("td %d, ta %d tb %d check\n",td,ta,tb);
        if (check[ta][tb] == 0 && map[ta][tb] == 0){ // 회전한 방향의 정면(기존방향의 왼쪽칸) 가보지 않음, 육지임
            a = ta;
            b = tb; // 왼쪽 전진
            cnt++;
            check[ta][tb]=1;
            time = 0;
            continue;
        }
        else { // 해당칸 가봄 or 바다
            time++;
        }
        if (time==4) { // 네방향 다 못감
            ta=a+back[d].first;
            tb=b+back[d].second;
            if (map[ta][tb]==0) { // 뒤쪽이 육지(갈수있음)
                a=ta;
                b=tb;
            }
            else // 뒤쪽이 바다(갈수없음)
                break;
            time = 0;
        }
    }
    cout<<cnt<<"\n";
}