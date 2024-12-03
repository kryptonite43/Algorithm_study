// 주사위 게임 3
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int solution(int a, int b, int c, int d) {
    int answer = 0, casenum = 0;
    int arr[4] = {a,b,c,d};
    sort(arr, arr+4, greater<>()); //내림차순 정렬함

    if (arr[0] == arr[3]) 
        answer = 1111*arr[0];
    else if ((arr[0] == arr[2]) || (arr[1]==arr[3])) { // 6663 | 6333
        if (arr[0] == arr[2])
            answer = pow(arr[0]*10+arr[3], 2);
        else
            answer = pow(arr[3]*10+arr[0], 2);
    }

    else if (arr[0] == arr[1] && arr[2]==arr[3]) // 4433
        answer = (arr[0]+arr[2])*abs(arr[0]-arr[2]);
    else if ((arr[0]!=arr[1]) && (arr[1]!=arr[2]) && (arr[2]!=arr[3])) // 6543
        answer = arr[3];
    else { //6654/6554/6544
        int i, multi=1;
        for (i=0; i<3; i++) {
            if (arr[i]==arr[i+1]) {
                break;
            }
        }
        for (int x=0; x<4; x++)
            multi *= arr[x];
        answer = multi / pow(arr[i], 2);
    }

    return answer;
}
