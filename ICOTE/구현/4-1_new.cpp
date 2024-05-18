// 상하좌우

#include <iostream>
#include <cstdio>
using namespace std;


int main() {
    int N;
    int x=1, y=1;
    char dir='a';

    scanf("%d\n", &N);
    while (1) {
        cin.get(dir);
        if (dir=='\n')
            break;
        switch(dir) {
            case 'L':
                if (y-1<=N && y-1>0)
                    y--;
                break;
            case 'R':
                if (y+1<=N && y+1>0)
                    y++;
                break;
            case 'U':
                if (x-1<=N && x-1>0)
                    x--;
                break;
            case 'D':
                if (x+1<=N && x+1>0)
                    x++;
                break;
        }
    }
    printf("%d %d\n\n", x,y);
    return 0;
}

// scanf 함수의 출력 값: 읽어들여 저장에 성공한 데이터 개수
// 엔터 입력시 종료 코드