#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int n, m, k, num, sum = 0, limit = 1;
    vector<int> v;

    scanf("%d %d %d", &n, &m, &k);
    for (int i = 0; i < n; i++) {
        scanf("%d", &num);
        v.push_back(num);
    }
    sort(v.begin(), v.end(), greater<int>());

    int cnt = (m / (k + 1)) * k + m % (k + 1); // 가장 큰 수가 더해지는 횟수
    sum = cnt * v[0] + (m - cnt) * v[1];

    /*  int cnt = m / (k + 1); // 묶음을 더하는 횟수
     int mod = m % (k + 1);
     sum = cnt * (v[0] * k + v[1]) + mod * v[0]; */
     
    printf("result: %d", sum);
    printf("\n\n");
    return 0;
}