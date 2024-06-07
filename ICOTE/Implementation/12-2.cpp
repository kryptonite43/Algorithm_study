#include <iostream>
#include <cstdio>
#include <algorithm>
#include <string>
using namespace std;

int main() {
    string s, res = "";
    char c;
    int sum = 0;

    cin>>s;

    for (int i=0; i<s.size(); i++) {
        if (s[i]>='A' && s[i]<='Z') // 알파벳 대문자인 경우
            res += s[i];
        else 
            sum += s[i]-'0';
    }
    sort(res.begin(), res.end());
    cout<<res;
    if (sum != 0) 
        cout<<sum;
    
    printf("\n\n");
    return 0;
}