#include <iostream>
#include <cstdio>
#include <string>
#include <vector>
using namespace std;

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    bool unlock = true;
    vector<vector<int>> board;
    vector<vector<int>> check;
    int n = lock.size();
    int m = key.size();
    
    for (int i=0; i<n+2*m; i++) {
        vector<int> v;
        for (int j=0; j<n+2*m; j++) {
            if (i>=m && j>= m && i<m+n && j<m+n)  // �ڹ��� ���� ���̸�
                v.push_back(lock[i-m][j-m]);
            else 
                v.push_back(0);
        }
        board.push_back(v);
    }
    check = board;

    for (int rot=0; rot<4; rot++) { // ȸ�� 4����
        // �ϳ��� ��������
        for (int i=0; i<=n+m; i++) { 
            for (int j=0; j<=n+m; j++) {
                // key ��ġ ����
                for (int mvi=0; mvi<m; mvi++) {
                    for (int mvj=0; mvj<m; mvj++) {
                        check[i+mvi][j+mvj] += key[mvi][mvj];
                    }
                }
                // lock�� �´��� Ȯ��
                for (int a=m; a<n+m; a++) {
                    for (int b=m; b<n+m; b++) {
                        if (check[a][b] != 1) {
                            unlock = false;
                            break;
                        }    
                    }
                }
                if (unlock)
                    return unlock;   
                check = board;
                unlock = true;
            }
        }
        // key ȸ����Ű��
        vector<vector<int>> tmp = key;

        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                key[j][m-i-1]=tmp[i][j];
            }
        }
    }  
    return false;
}

int main() {
    vector<vector<int>> k, l;
    int m,n;
    cin>>m>>n;
    for (int i=0; i<m; i++) {
        vector<int> v;
        for (int j=0; j<m; j++) {
            int x;
            cin>>x;
            v.push_back(x);
        }
        k.push_back(v);
    }
    for (int i=0; i<n; i++) {
        vector<int> v;
        for (int j=0; j<n; j++) {
            int x;
            cin>>x;
            v.push_back(x);
        }
        l.push_back(v);
    }
    bool answer = solution(k,l);
    if (answer) {
        cout<<"true";
    }
    else {
        cout<<"false";
    }
    printf("\n\n");
    return 0;
}