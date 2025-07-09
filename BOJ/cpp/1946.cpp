#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;
int t, n;
int doc, view, cand1, cand2;
vector<pair<int, int>> byDoc;  // doc, view
vector<pair<int, int>> byView; // view, doc

int sortApplicant(vector<pair<int,int>> bySth) {
    sort(bySth.begin(), bySth.end());
    pair<int,int> cur = bySth[0];

    for (int i = 0; i < bySth.size() - 1; i++) {
        if (cur.second < bySth[i + 1].second) { //i+1 탈락시키기
            // i+1이 탈락하므로 cur은 변동 없음
            bySth[i+1].first = 0;
            bySth[i+1].second = 0;
        }
        else {
            cur = bySth[i+1];
        }
    }

    sort(bySth.begin(), bySth.end());
    int ind = 0;
    for (pair<int,int> x : bySth){
        if (x.first == 0 && x.second == 0)
            ind++;
        else
            break;
    }
    if (ind != 0)
        bySth.erase(bySth.begin(), bySth.begin() + ind);

    return bySth.size();
}


int main() {    
    cin>>t;
    while (t--) {
        cin>>n;
        for (int i=0; i<n; i++) {
            cin>>doc>>view;
            byDoc.push_back({doc, view});
            byView.push_back({view, doc});
        }
        // 1. 서류 기준 정렬해 구하기
        cand1 = sortApplicant(byDoc);
        // 2. 면접 기준 정렬해 구하기
        cand2 = sortApplicant(byView);
        printf("%d\n",max(cand1,cand2));
        
        cand1 = 0;
        cand2 = 0;
        byDoc.clear();
        byView.clear();
    }

    printf("\n");
    return 0;
}