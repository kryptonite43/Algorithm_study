#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int n, k, cnt = 0;
    scanf("%d %d", &n, &k);
    while (n != 1) {
        n % k == 0 ? n /= k : n--;
        cnt++;
        printf("n now: %d\n", n);
    }
    printf("%d", cnt);
    printf("\n\n");
    return 0;
}