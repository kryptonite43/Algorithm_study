#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
#include <cmath>
#include <numeric>
using namespace std;

int arrtog[8010] = {0}; // �������(�ֺ�) ���� �迭. 0~4000: ���� �ε���, -1~-4000: +8000 �� �ε����� �߰�
int arr[500010]; // ���� ������ �ִ��� �����ϴ� �Ϲ� �迭
vector<pair<int,int>> v; // {����Ƚ��, �ش� ��}

bool compare(pair<int,int> a, pair<int,int> b) {
    // ����Ƚ�� ��������, �ش� �� ��������
    // ����Ƚ��: a.first, �ش� ��: a.second
    if (a.first!=b.first) return a.first > b.first;
    else 
        return a.second < b.second;
}

int main() {
    int n, mean, median, mode, range; // ������, �߰���, �ֺ�, ����
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
    // mode �ֺ�
    // ������ ���� arrtog�� ������ pair�� �ٲ� ����
    for (int i=0; i<8001; i++) {
        if (i<4001)
            v.push_back({arrtog[i],i});
        else
            v.push_back({arrtog[i],i-8001});
    }
    sort(v.begin(), v.end(), compare);
    // ���� �� ���� ������ �ֺ� �� �� ��°�� ���� ���� ����Ѵ�.
    
    int maxcount = v[0].first; // �ִ� ���� Ƚ��
    if (v[1].first == maxcount) // �ֺ��� ���� ��
        mode = v[1].second;
    else
        mode = v[0].second;

    range = *max_element(arr,arr+n)-*min_element(arr,arr+n);

    printf("%d\n%d\n%d\n%d",mean,median,mode,range);
    printf("\n");
    return 0;
}