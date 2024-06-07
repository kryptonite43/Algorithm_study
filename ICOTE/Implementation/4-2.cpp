#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

int main() {
    int hour=0, min=60, sec=60, cnt = 0;

    cin>>hour;
    
    for (int i=0; i<=hour; i++){
        for(int j=0; j<min; j++) {
            for(int k=0; k<sec; k++){
                string h = to_string(i);
                string m = to_string(j);
                string s = to_string(k);
                string sum = h+m+s;
                if (sum.find('3')!=string::npos) {
                    cnt++;
                } 
            }
        }
    }
    printf("%d", cnt);
    printf("\n\n");
    return 0;
}