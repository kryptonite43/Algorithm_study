#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int n, x = 1, y = 1, cnt = 0;
    string str;
    char c;
    int dx[4] = {0, 0, -1, 1};
    int dy[4] = {-1, 1, 0, 0};
    char moves[4] = {'L', 'R', 'U', 'D'};
    cin >> n;
    cin.ignore();
    getline(cin, str);

    for (int i = 0; i < str.size(); i++) {
        c = str[i];
        for (int j = 0; j < 4; j++) {
            if (c == moves[j]) {
                int nx = x+dx[j];
                int ny = y+dy[j];

                if (nx==0||nx==n+1||ny==0|ny==n+1) continue;
                else {
                    x = nx;
                    y = ny;
                }
                break;
            }
        }
    }

    /* for (int i=0; i<str.size(); i++) {
        c = str[i];
        switch(c) {
            case 'L':
                y--;
                break;
            case 'R':
                y++;
                break;
            case 'U':
                x--;
                break;
            case 'D':
                x++;
                break;
        }
        cnt++;
        if (x == 0 | y == 0){
                (x == 0) ? x++ : y++;
        }
        else if (x == n + 1 | y == n + 1){
                (x == n + 1) ? x-- : y--;
        }
    } */
    printf("%d %d", x, y);
    printf("\n\n");
    return 0;
}