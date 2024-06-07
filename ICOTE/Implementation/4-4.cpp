#include <iostream>
#include <cstdio>
#include <vector>
using namespace std;

int main() {
    int n, m, a, b, d, x, cnt=0;
    vector<vector<int>> v, visit;
    int leftx[8] = {0,-1,0,1}; // i일 때 a 왼쪽으로 이동 변화 값 dx[i]
    int lefty[8] = {-1,0,1,0};
    int backx[4] = { 1,0,-1,0};
    int backy[4] = {0,-1,0,1};
    int dx[4]= {0,-1,0,1};
    int dy[4] =  {-1,0,1,0};

    cin>>n>>m;
    cin>>a>>b>>d;

    for(int i=0; i<n; i++) {
        vector<int> tmp, visit1;
        for (int j=0; j<m; j++) {
            cin>>x;
            tmp.push_back(x);
            visit1.push_back(0);
        }
        v.push_back(tmp);
        visit.push_back(visit1);
    }
    visit[a][b]=1;
    while (true) {
        int check=0;
        for (int i=0; i<4; i++) {
            int nx = a+dx[i]; 
            int ny = b+dx[i];
            if (visit[nx][ny]==0 && v[nx][ny]==0) { // 안가본 육지가 있다면
                printf("for - 안가본 육지가 있다\n");
                check=1;
                break;
            }
        }
        if (check) { // 네방향 중 안가본 칸 있다면
            printf("check - 안가본 칸이 있다\n");
            if (visit[a+dx[0]][b+dy[0]] == 0){ // 왼쪽 안 가봄
                printf("if - 왼쪽 안 가봄\n");
                d = (d + 3) % 4;                               // 방향 전환
                a += leftx[d];                                 // 왼쪽 1칸 전진
                b += lefty[d];
                visit[a][b] = 1;
            }
            else {
                printf("else - 왼쪽 가봄\n");
                d = (d + 3) % 4; 
            }

        }
        else { // 네방향 모두 가본칸or 바다로 되어 있는 칸
            printf("네방향 모두 가본칸or 바다로 되어 있는 칸\n");
            a += backx[d];
            b += backy[d];
            if (v[a][b]) // 뒤쪽이 바다임 -> 움직임 멈춤
                break;
            else {
                printf("뒤쪽 바다 아님\n");
                visit[a][b] = 1;
            }
        }
        printf("(%d, %d), d = %d\n",a,b,d);
    }

    // 가본 칸 개수 세기
    for(int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            if(visit[i][j]) {
                printf("방문: (%d, %d)\n",i,j);
                cnt++;
            }
                
        }
    }

    printf("%d\n\n",cnt);
    return 0;
}