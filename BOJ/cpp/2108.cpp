#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
#include <cmath>
#include <numeric>
using namespace std;

int arrtog[8010] = {0}; // 계수정렬(최빈값) 위한 배열. 0~4000: 원래 인덱스, -1~-4000: +8000 한 인덱스에 추가
int arr[500010]; // 무슨 값들이 있는지 저장하는 일반 배열
vector<pair<int,int>> v; // {등장횟수, 해당 값}

bool compare(pair<int,int> a, pair<int,int> b) {
    // 등장횟수 내림차순, 해당 값 오름차순
    // 등장횟수: a.first, 해당 값: a.second
    if (a.first!=b.first) return a.first > b.first;
    else 
        return a.second < b.second;
}

int main() {
    int n, mean, median, mode, range; // 산술평균, 중간값, 최빈값, 범위
    cin>>n;
    for (int i=0; i<n; i++) {
        int x;
        cin>>x;
        arr[i]=x;
        if (x<0)
            arrtog[x+8001]++;
        else
            arrtog[x]++;
    }
    sort(arr, arr+n);
    
    mean = round((double)accumulate(arr, arr+n, 0) / n);
    median = arr[n/2];
    // mode 최빈값
    // 정렬을 위해 arrtog의 값들을 pair로 바꿔 저장
    for (int i=0; i<8001; i++) {
        if (i<4001)
            v.push_back({arrtog[i],i});
        else
            v.push_back({arrtog[i],i-8001});
    }
    sort(v.begin(), v.end(), compare);
    // 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
    
    int maxcount = v[0].first; // 최대 등장 횟수
    if (v[1].first == maxcount) // 최빈값이 여러 개
        mode = v[1].second;
    else
        mode = v[0].second;

    range = *max_element(arr,arr+n)-*min_element(arr,arr+n);

    printf("%d\n%d\n%d\n%d",mean,median,mode,range);
    printf("\n");
    return 0;
}