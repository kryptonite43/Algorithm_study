#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int limit, sum = 0, i;

    scanf("%d", &limit);
    for (i = 1; sum < limit; i++) {
        sum += i;
    }
    printf("%d", i-1);
    printf("\n\n");
    return 0;
} 