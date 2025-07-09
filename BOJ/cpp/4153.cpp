#include <iostream>
#include <cstdio>
#include <cmath>
using namespace std;

int main() {
    double a = 1, b = 1, c = 1, az,bz,cz;
    double maxi;

    while (a||b||c) {
        cin >> a >> b >> c;
        if ((a==0)&&(b==0)&&(c==0))
            return 0;

        az=pow(a,2);
        bz=pow(b,2);
        cz=pow(c,2);
        if ((cz-az-bz==0)||(az-bz-cz==0)||(bz-az-cz==0))
            cout<<"right\n";
        else
            cout<<"wrong\n";
    }
    
}