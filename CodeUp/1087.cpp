#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    long long n;
    long long sum = 0;
    scanf("%lld", &n);
    for (long long i = 1; sum < n; i++){
        sum += i;
    }

    printf("%lld", sum);

    printf("\n\n");
    return 0;
}