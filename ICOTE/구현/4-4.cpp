#include <iostream>
#include <cstdio>
#include <vector>
using namespace std;

int main() {
    int n, m, a, b, d, x, cnt=0;
    vector<vector<int>> v, visit;
    int leftx[8] = {0,-1,0,1}; // i�� �� a �������� �̵� ��ȭ �� dx[i]
    int lefty[8] = {-1,0,1,0};
    int backx[4] = { 1,0,-1,0};
    int backy[4] = {0,-1,0,1};
    int dx[4]= {0,-1,0,1};
    int dy[4] =  {-1,0,1,0};

    cin>>n>>m;
    cin>>a>>b>>d;

    for(int i=0; i<n; i++) {
        vector<int> tmp, visit1;
        for (int j=0; j<m; j++) {
            cin>>x;
            tmp.push_back(x);
            visit1.push_back(0);
        }
        v.push_back(tmp);
        visit.push_back(visit1);
    }
    visit[a][b]=1;
    while (true) {
        int check=0;
        for (int i=0; i<4; i++) {
            int nx = a+dx[i]; 
            int ny = b+dx[i];
            if (visit[nx][ny]==0 && v[nx][ny]==0) { // �Ȱ��� ������ �ִٸ�
                printf("for - �Ȱ��� ������ �ִ�\n");
                check=1;
                break;
            }
        }
        if (check) { // �׹��� �� �Ȱ��� ĭ �ִٸ�
            printf("check - �Ȱ��� ĭ�� �ִ�\n");
            if (visit[a+dx[0]][b+dy[0]] == 0){ // ���� �� ����
                printf("if - ���� �� ����\n");
                d = (d + 3) % 4;                               // ���� ��ȯ
                a += leftx[d];                                 // ���� 1ĭ ����
                b += lefty[d];
                visit[a][b] = 1;
            }
            else {
                printf("else - ���� ����\n");
                d = (d + 3) % 4; 
            }

        }
        else { // �׹��� ��� ����ĭor �ٴٷ� �Ǿ� �ִ� ĭ
            printf("�׹��� ��� ����ĭor �ٴٷ� �Ǿ� �ִ� ĭ\n");
            a += backx[d];
            b += backy[d];
            if (v[a][b]) // ������ �ٴ��� -> ������ ����
                break;
            else {
                printf("���� �ٴ� �ƴ�\n");
                visit[a][b] = 1;
            }
        }
        printf("(%d, %d), d = %d\n",a,b,d);
    }

    // ���� ĭ ���� ����
    for(int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            if(visit[i][j]) {
                printf("�湮: (%d, %d)\n",i,j);
                cnt++;
            }
                
        }
    }

    printf("%d\n\n",cnt);
    return 0;
}