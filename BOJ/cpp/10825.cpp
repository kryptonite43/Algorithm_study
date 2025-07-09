#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
//  pair<pair<국, pair<영, 수>>, 이름>
// 국어: a.first.first
// 영어: a.first.second.first
// 수학: a.first.second.second
// 이름: a.second
bool compare(pair<pair<int,pair<int,int>>,string> a, pair<pair<int,pair<int,int>>,string> b) {
    if (a.first.first != b.first.first) return a.first.first > b.first.first; // 국어
    else if (a.first.second.first != b.first.second.first) return a.first.second.first < b.first.second.first; // 영어
    else if (a.first.second.second != b.first.second.second) return a.first.second.second > b.first.second.second; // 수학
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