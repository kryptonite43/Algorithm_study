#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int x, y, cnt = 0;
    string loc;
    int dx[8] = {-2, -2, -1, 1, 2, 2, 1, -1};
    int dy[8] = {-1, 1, 2, 2, 1, -1, -2, -2};

    cin >> loc;
    x = loc[1]-'0';
    y = loc[0] - 'a' + 1;

    for (int i = 0; i < 8; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        //printf("(%d, %d)\n", nx, ny);
        if (nx<1||nx>8||ny<1||ny>8)
            continue;
        else
            cnt++;
    }
    printf("%d", cnt);
    printf("\n\n");
    return 0;
}