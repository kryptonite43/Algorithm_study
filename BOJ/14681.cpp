#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int x,y,ans;
    cin>>x;
    cin>>y;
    if (x>0 && y>0)
        ans=1;
    else if (x<0 && y>0)
        ans=2;
    else if (x<0 && y<0)
        ans=3;
    else
        ans=4;
    

    printf("%d\n",ans);
    return 0;
}