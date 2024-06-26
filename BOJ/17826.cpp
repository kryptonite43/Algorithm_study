#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int arr[51], hong;
    arr[0] = 0;
    for (int i=1; i<=50; i++) {
        cin>>arr[i];
    }
    cin>>hong;

    for (int i=1; i<=50; i++) {
        if (arr[i]==hong) {
            if (i<6)
                printf("A+\n");
            else if (i<16) 
                printf("A0\n");
            else if (i<31) 
                printf("B+\n");
            else if (i<36) 
                printf("B0\n");
            else if (i<46) 
                printf("C+\n");
            else if (i<49) 
                printf("C0\n");
            else
                printf("F\n");
            
        }
    }
    return 0;
}