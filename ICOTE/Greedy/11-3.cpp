#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

int main() {
    string s;
    int zero = 0, one = 0, bfor, cur;

    cin>>s;
    bfor = s.front()-'0';
    for (char c: s) {
        cur = c-'0';
        if (bfor != cur) {
            if (bfor)
                one++;
            else 
                zero++;
        }
        bfor=cur;
        //printf("one: %d, zero: %d\n", one, zero);
    }
    if (bfor) one++;
    else zero++;
    //printf("one: %d, zero: %d\n", one, zero);
    printf("%d", min(one,zero));
    printf("\n\n");
    return 0;
}