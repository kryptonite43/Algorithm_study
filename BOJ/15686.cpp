#include <iostream>
#include <cstdio>
#include <cmath>
#include <vector>
#include <algorithm>
using namespace std;
int info, mini, sum=0, finalmini=100000000;
vector<pair<int,int>> home;
vector<pair<int,int>> chicken;
vector<vector<int>> dist;
vector<vector<int>> ans;

vector<vector<int>> permutation(vector<int> target, int n, int r) {
	// ���� ���� 0�� �ε����� ������ ������ ������
	// nCr -> n=��ü �� 6, r=���� ���� 4. 6C4
	vector<int> v;
    vector<vector<int>> res;
    int left=n-r;
    while (r--) v.push_back(0);
    while (left--) v.push_back(1);
    
	do {
        vector<int> temp;
		for (int i=0; i<v.size();i++) {
			if (v.at(i)==0) {
                temp.push_back(target[i]);
			}
		}
		res.push_back(temp);
	} while(next_permutation(v.begin(),v.end()));
    return res;
}


int main() {
    int n, m;

    cin >> n >> m;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            cin>>info;
            switch(info) {
                case 1:
                    home.push_back({i,j});
                    break;
                case 2:
                    chicken.push_back({i,j});
                    break;
            }
        }
    }
    for (int i=0; i<home.size(); i++) { // �� �ϳ��� ����
        vector<int> minians;
        // ��� ġŲ���� ���� ġŲ �Ÿ� ���صα�
        int x = home[i].first;
        int y = home[i].second;
        vector<int> eachdist; // �� �������� �Ÿ��� ���� ����
        for (int j=0; j<chicken.size(); j++) {
            int cx = chicken[j].first;
            int cy = chicken[j].second;
            int d = abs(x-cx)+abs(y-cy);
            eachdist.push_back(d);
        }
        dist.push_back(eachdist);
        
        
        vector<vector<int>> mpermute = permutation(eachdist, chicken.size(), m); // m���� �̷���� ����
        for (vector<int> a : mpermute) { // a�� m���� ���� ���� �� ���� ��Ÿ��
            mini = 10000000;
            for (int z : a) {
                mini = min(mini, z); // �ش� ���տ����� �ּڰ� ��� ������Ʈ�ϸ� ���ϱ�
            }
            minians.push_back(mini);
        }
        ans.push_back(minians);
    }

    int cnt = ans[0].size();
    for (int i=0; i<cnt; i++) {
        for (int j=0; j< ans.size(); j++) {
            sum+=ans[j][i];
        }
        finalmini = min(finalmini, sum);
        sum=0;
    }
    
    printf("%d\n",finalmini);
    return 0;
}