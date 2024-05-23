#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    char c = 1;
    
    while (c != 'q') {
        scanf("%c", &c);
        if (c != ' ')
            printf("%c\n", c);
    }

    printf("\n\n");
    return 0;
} 