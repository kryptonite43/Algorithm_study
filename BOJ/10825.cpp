#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
//  pair<pair<��, pair<��, ��>>, �̸�>
// ����: a.first.first
// ����: a.first.second.first
// ����: a.first.second.second
// �̸�: a.second
bool compare(pair<pair<int,pair<int,int>>,string> a, pair<pair<int,pair<int,int>>,string> b) {
    if (a.first.first != b.first.first) return a.first.first > b.first.first; // ����
    else if (a.first.second.first != b.first.second.first) return a.first.second.first < b.first.second.first; // ����
    else if (a.first.second.second != b.first.second.second) return a.first.second.second > b.first.second.second; // ����
    return a.second < b.second;
}

int main() {
    int n, kor, eng, math;
    string name;
    vector<pair<pair<int,pair<int,int>>,string>> scores;

    cin>>n;
    for (int i=0; i<n; i++) {
        cin>>name>>kor>>eng>>math;
        scores.push_back({{kor,{eng,math}},name});
    }
    sort(scores.begin(), scores.end(), compare);
    for (int i=0; i<n; i++) {
        cout<<scores[i].second<<"\n";
    }
    printf("\n");
    return 0;
}