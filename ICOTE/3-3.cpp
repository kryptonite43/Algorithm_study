#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n, m, res = 0;

    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++) {
        int minimum = 10001;
        for (int j = 0; j < m; j++) {
            int x;
            scanf("%d", &x);
            minimum = min(x, minimum);
        }
        res = max(minimum, res);
    }
    printf("%d", res);
    printf("\n\n");
    return 0;
}