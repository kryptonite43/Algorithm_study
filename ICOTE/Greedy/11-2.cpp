#include <iostream>
#include <cstdio>
#include <string>
#include <cstdlib>
#include <typeinfo>
using namespace std;

int main() {
    string s;
    int num, res = 1;

    cin>>s;
    
    for (char c: s){
        if (c=='0'||c=='1') {
            res += c-'0';

        }
        else {
            res *= c-'0';
        }
        printf("c: %d, res: %d\n", c-'0', res);
    }
    printf("%d", res);
    printf("\n\n");
    return 0;
}