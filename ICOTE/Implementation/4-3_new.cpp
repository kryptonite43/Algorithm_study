// 왕실의 나이트

#include <iostream>
#include <cstdio>
using namespace std;
int dx[8] = {-1, 1, 2, 2, 1, -1, -2, -2};
int dy[8] = {-2, -2, -1, 1, 2, 2, 1, -1};
int cnt = 8;
int main() {
    char coor[2];
    int x,y;
    
    cin>>coor;
    x = coor[0] - 'a' + 1;
    y = coor[1] - '0';
    for (int i=0; i<8; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 1 || nx > 8 || ny < 1 || ny > 8) {
            cnt--;
        }
    }
    printf("%d\n\n", cnt);
    return 0;
}