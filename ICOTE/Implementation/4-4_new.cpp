#include <iostream>
#include <cstdio>
#include <vector>
using namespace std;

int main() {
    int n,m,a,b,d, td, ta, tb, cnt=1, time=0;
    int map[51][51], check[51][51];
    vector<pair<int,int>> left = {{0,-1},{-1,0},{0,1},{1,0}};
    vector<pair<int,int>> back = {{1,0},{0,-1},{-1,0},{0,1}};
    vector<pair<int,int>> done;
    cin>>n>>m;
    cin>>a>>b>>d;
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            cin>>map[i][j];
            if (map[i][j]==1) // 1�̸� �ٴ��̹Ƿ� ���� ĭ���� �Ǵ�
                check[i][j]=1;
            else
                check[i][j]=0;

        }
    }

    check[a][b]=1;
    while (1) {
        td = (d+3)%4; // Ž���� ���� (���� ȸ���� ��)
        ta = a+left[d].first;
        tb = b+left[d].second;
        //printf("td %d, ta %d tb %d check\n",td,ta,tb);
        if (check[ta][tb] == 0 && ta >= 0 && ta < n && tb >= 0 && tb < m){ // ���� ���� ������ ����
            d = td; // ���� �ٲٱ�
            a = ta;
            b = tb; // ���� ����
            cnt++;
            check[ta][tb]=1;
            time =0;
        }
        else if (check[ta][tb] == 1 && ta >= 0 && ta < n && tb >= 0 && tb < m) { // ���� ���� ����
            d = td;
        }
        time++;
        if (time==4) {
            a+=back[d].first;
            b+=back[d].second;
            check[a][b]=1;
            if (map[a][b]==0) {
                cnt++;
            }
            else {
                printf("%d\n\n",cnt);
                return 0;
            }
            time = 0;
        }
        cout<<"===============\n";
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                cout<< check[i][j] <<" ";
            }
            cout<<"\n";
        }
        cout<<"===============\n\n";
    }
    
}