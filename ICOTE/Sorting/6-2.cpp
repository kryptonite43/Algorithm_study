// <3> ���� ���� - ������ ���� ������� �л� ����ϱ�
#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n, score;
    string name;
    vector<pair<int,string>> v;

    cin>>n;
    for (int i=0; i<n; i++) {
        cin>>name>>score;
        v.push_back({score,name});
    }
    sort(v.begin(), v.end());

    for (int i=0; i<n; i++) {
        cout<<v[i].second<<" ";
    }
    printf("\n");   
    return 0;
}