#include <iostream>
#include <cstdio>
#include <vector>
using namespace std;

int main() {
    int n,m,a,b,d, td, ta, tb, cnt=1, time=0;
    int map[50][50], check[50][50];
    vector<pair<int,int>> left = {{-1,0},{0,1},{1,0},{0,-1}};
    vector<pair<int,int>> back = {{1,0},{0,-1},{-1,0},{0,1}};
    cin>>n>>m;
    cin>>a>>b>>d;
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            cin>>map[i][j];
        }
    }

    check[a][b]=1;
    while (1) {
        d = (d+3)%4; // Ž���� ���� (���� ȸ���� ��)
        ta = a+left[d].first;
        tb = b+left[d].second;
        //printf("td %d, ta %d tb %d check\n",td,ta,tb);
        if (check[ta][tb] == 0 && map[ta][tb] == 0){ // ȸ���� ������ ����(���������� ����ĭ) ������ ����, ������
            a = ta;
            b = tb; // ���� ����
            cnt++;
            check[ta][tb]=1;
            time = 0;
            continue;
        }
        else { // �ش�ĭ ���� or �ٴ�
            time++;
        }
        if (time==4) { // �׹��� �� ����
            ta=a+back[d].first;
            tb=b+back[d].second;
            if (map[ta][tb]==0) { // ������ ����(��������)
                a=ta;
                b=tb;
            }
            else // ������ �ٴ�(��������)
                break;
            time = 0;
        }
    }
    cout<<cnt<<"\n";
}