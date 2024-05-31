#include <iostream>
#include <cstdio>
#include <cmath>
using namespace std;
int board[51][51], can[51][51];
int blk[8][8]; // 왼쪽 위가 까만색인 정답 보드
int wht[8][8]; // 왼쪽 위가 흰색인 정답 보드

int main() {
    int n,m, black=0, white=0, mini=2510;
    cin>>n>>m;
    for (int i = 0; i < 8; i++) {
        for (int j=0; j<8; j++) {
            blk[i][j]=((i+j)%2==0)?0:1;
            wht[i][j]=((i+j)%2==1)?0:1;
        }
    }

    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            char c;
            cin>>c;
            board[i][j]=(c=='W')?1:0;
        }
    }

    for (int i=0; i<=n-8; i++) {
        for (int j=0; j<=m-8; j++) { // 8*8 체스판의 왼쪽 위 시작점이 (i,j)
            for (int k=i; k<i+8; k++) {
                for (int l=j; l<j+8; l++) {
                    can[k-i][l-j]=board[k][l];
                }
            }
            black=0, white=0;
            for (int k=0; k<8; k++) {
                for (int l=0; l<8; l++) {
                    if (can[k][l]!=blk[k][l]) 
                        black++;
                    
                    if (can[k][l]!=wht[k][l])  
                        white++;
                }
            }
            mini = min(min(black,white),mini);
        } 
    }
    

    printf("%d\n\n",mini);
    return 0;
}