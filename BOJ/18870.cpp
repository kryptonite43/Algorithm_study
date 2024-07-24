#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n, pivot, index=0;
    vector<pair<int,int>> v; // 입력한 수, 입력 순서(index)
    vector<pair<int,int>> neu; // 기존 수의 입력 순서(index), 압축된 수

    cin>>n;
    for (int i=0; i<n; i++) {
        int x;
        cin>>x;
        v.push_back({x,i});
    }

    sort(v.begin(),v.end()); // 입력 수 기준 오름차순 정렬
    pivot = v[0].first;
    neu.push_back({v[0].second, 0});
    for(int i=1; i<v.size(); i++) {
        if (pivot<v[i].first) { // 이전 수보다 크다
            index++;
        }
        neu.push_back({v[i].second, index});
        pivot = v[i].first;
    }

    sort(neu.begin(), neu.end());
    for (int i=0; i<neu.size(); i++) {
        cout<<neu[i].second<<" ";
    }

    printf("\n");
    return 0;
}