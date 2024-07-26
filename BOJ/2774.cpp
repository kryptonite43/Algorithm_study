#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int t, x, cur;
    

    cin>>t;
    while (t--) {
        bool arr[10]={0,};
        int ans = 0;
        cin >> x;
        while (x>0) {
            cur = x%10;
            x /= 10;
            arr[cur]=true;
        }
        for (int i=0; i<10; i++) {
            if (arr[i])
                ans++;
        }
        cout<<ans<<"\n";
    }

    printf("\n");
    return 0;
}