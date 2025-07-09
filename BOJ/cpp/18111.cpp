#include <iostream>
#include <cstdio>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;
int n, m, b, mini=257,maxi=0, mintime=150000000, height=0;
int house[510][510], temp[510][510], house2[261000];
vector<pair<int,int>> timearr;

int bigger(int diff, int time) {
    time += diff*2; 
    b += diff;
    return time;
}

int smaller(int diff, int time) {
    time += diff;
    b -= diff;
    if (b<0) return -1;
    return time;
}

int main() {
    scanf("%d %d %d", &n, &m, &b);
    int orgb = b;
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            cin >> house[i][j];
            mini = min(mini, house[i][j]);
            maxi = max(maxi, house[i][j]);
        }
    }
    int x=0;
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            house2[x++] = house[i][j];
        }
    }

    sort(house2, house2+n*m, greater<int>());
    int y=0;
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            house[i][j]=house2[y++];
        }
    }

    for (int i=mini; i<=maxi; i++) {
        memcpy(&temp, &house, sizeof(house));
        int temptime=0;
        b = orgb;

        for (int j=0; j<n; j++) {
            for (int k=0; k<m; k++) {
                int cur = temp[j][k];
                temptime = (cur-i > 0) ? bigger(cur-i, temptime) : smaller(abs(cur-i), temptime);
                if (temptime == -1)
                    break;
            }
            if (temptime == -1)
                break;
        }
        if (temptime != -1) {
            if (mintime > temptime) {
                mintime = temptime;
                height = i;
            }
            else if (mintime == temptime) {
                height = max(height, i);
            }
        }
    }

    printf("%d %d\n\n", mintime, height);
    return 0;
}
