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
	// 벡터 값이 0인 인덱스를 가지고 조합을 진행함
	// nCr -> n=전체 값 6, r=조합 개수 4. 6C4
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
    for (int i=0; i<home.size(); i++) { // 집 하나에 대해
        vector<int> minians;
        // 모든 치킨집에 대한 치킨 거리 구해두기
        int x = home[i].first;
        int y = home[i].second;
        vector<int> eachdist; // 각 집마다의 거리들 모은 벡터
        for (int j=0; j<chicken.size(); j++) {
            int cx = chicken[j].first;
            int cy = chicken[j].second;
            int d = abs(x-cx)+abs(y-cy);
            eachdist.push_back(d);
        }
        dist.push_back(eachdist);
        
        
        vector<vector<int>> mpermute = permutation(eachdist, chicken.size(), m); // m개로 이루어진 조합
        for (vector<int> a : mpermute) { // a는 m개씩 묶인 조합 한 개를 나타냄
            mini = 10000000;
            for (int z : a) {
                mini = min(mini, z); // 해당 조합에서의 최솟값 계속 업데이트하며 구하기
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