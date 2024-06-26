#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int t;
    cin>>t;
    string str;

    while (t--) {
        cin>>str;
        cout<<str[0]<<str[str.size()-1]<<"\n";
        str="";
    }

    printf("\n\n");
    return 0;
}