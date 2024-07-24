#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n, pivot, index=0;
    vector<pair<int,int>> v; // �Է��� ��, �Է� ����(index)
    vector<pair<int,int>> neu; // ���� ���� �Է� ����(index), ����� ��

    cin>>n;
    for (int i=0; i<n; i++) {
        int x;
        cin>>x;
        v.push_back({x,i});
    }

    sort(v.begin(),v.end()); // �Է� �� ���� �������� ����
    pivot = v[0].first;
    neu.push_back({v[0].second, 0});
    for(int i=1; i<v.size(); i++) {
        if (pivot<v[i].first) { // ���� ������ ũ��
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