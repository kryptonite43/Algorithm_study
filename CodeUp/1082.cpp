#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int i, n;
    scanf("%x", &n);

    for (i=1; i<=0xF; i++) {
        printf("%X*%X=%X\n",n,i,n*i);
    }

    printf("\n\n");
    return 0;
}