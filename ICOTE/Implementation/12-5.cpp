#include <iostream>
#include <cstdio>
#include <vector>
#include <queue>
using namespace std;

int board[110][110];
int n, k, l, cnt, d = 0, curx = 0, cury = 0, rot = 0, orgx, orgy;
bool correct = true;
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
vector<pair<int, char>> v;
queue<pair<int, int>> q;

bool check() { /*큐에 있는 것에 도착=> 계속, 아닐 시 종료하는 함수*/
    int size = q.size();
    
    for (int i=0; i<size; i++) {
        if (curx == q.front().first && cury == q.front().second) { // 큐에 존재
            if (curx == 0 && cury == 0)
                continue;
            return false;
        }
        else { // 큐에 존재 x
            int orgx = q.front().first;
            int orgy = q.front().second;
            q.pop();
            q.push({orgx, orgy});
        }
    }
    return true;
}

int main() {
    cin >> n;
    cin >> k;
    for (int i=0; i<k; i++) {
        int row, col;
        cin >> row >> col;
        board[row - 1][col - 1] = 1;
    }
    cin >> l;
    for (int i=0; i<l; i++) {
        int x;
        char c;
        cin >> x >> c;
        v.push_back({x,c});
    }

    q.push({0,0});

    for (cnt = 1; ; cnt++) {
        curx += dx[d];
        cury += dy[d];
        correct = check();
        if (curx < 0 || curx >= n || cury < 0 || cury >= n || correct == false) { // 이동한좌표=> 범위밖 or 자기자신만남
            cout<<cnt<<endl;
            return 0;
        }
        if (board[curx][cury] == 1) {// 사과 존재
            board[curx][cury] = 0;
            q.push({curx, cury});
        }
            
        else { // 사과 없음
            orgx = q.front().first;
            orgy = q.front().second;
            q.pop();
            q.push({curx, cury});
        }

        
        if (cnt == v[rot].first) {
            switch(v[rot].second) {
                case 'L': // d 감소 3->2, 0->3
                    d = (d+3)%4;
                    break;
                case 'D': // d 증가 0->1, 3->0
                    d = (d+1)%4;
                    break;
            }
            rot++;
        }      
    }
    return 0;
}