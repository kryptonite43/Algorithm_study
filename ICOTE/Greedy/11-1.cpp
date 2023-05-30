#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n, groupMembers = 0, groupCount = 0;
    vector<int> v;

    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        int x;
        scanf("%d", &x);
        v.push_back(x);
    }
    sort(v.begin(), v.end());
    
    for (int i=0;i<n;i++){
        if (++groupMembers >= v[i]) {
            groupCount++;
            groupMembers = 0;
        }
        printf("���� ����� ������: %d, ���� �׷����: %d, ���� �׷��: %d\n", v[i], groupMembers, groupCount);
    }
    printf("%d", groupCount);
    printf("\n\n");
    return 0;
}