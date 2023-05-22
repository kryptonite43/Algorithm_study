#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int n, count = 0;
    int arr[4] = {500, 100, 50, 10};
    scanf("%d", &n);

    for (int i = 0; i < 4; i++) {
        count += n/arr[i];
        n %= arr[i];
        printf("%d원 후 개수: %d\n", arr[i], count);
    }
    printf("%d", count);
    printf("\n\n");
    return 0;
}