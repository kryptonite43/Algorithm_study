#include <iostream>
#include <cstdio>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

int n;
vector<int> oper; 
int num[12];
int mini = 1e+9+1;
int maxi = -1e+9-1;
int tmp = 0;

int main() {
    cin.tie(0); cout.tie(0);
    ios_base::sync_with_stdio(false);

    cin>>n;
    for (int i=0; i<n; i++) {
        cin>>num[i];
    }
    for (int i=0; i<4; i++) {
        int x;
        cin>>x;
        for (int j=0; j<x; j++) {
            oper.push_back(i);
        }
    }
    
    do {
        tmp = num[0];
        for (int i=0; i<oper.size(); i++) { // 연산 횟수
            int cur = oper[i];
            // tmp와 num[i+1]을 oper[i] 로 계산하고, 이를 tmp에 저장
            switch(cur) {
                case 0: // +
                    tmp += num[i+1];
                    break;
                case 1: // -
                    tmp -= num[i+1];
                    break;
                case 2: // *
                    tmp *= num[i+1];
                    break;
                case 3: // /
                    tmp /= num[i+1];
                    break;
            } 
        }
        // maxi, mini 업데이트
        maxi = max(maxi, tmp);
        mini = min(mini, tmp);
    } while (next_permutation(oper.begin(), oper.end()));

    cout<<maxi<<"\n"<<mini;
    return 0;
}
