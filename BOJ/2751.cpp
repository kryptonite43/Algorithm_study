#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;

int n;
int num[1000010] = {0};

void quickSort(int* arr, int start, int end) {
    // 원소가 1개면 종료
    if (start>=end) return;
    // 피벗은 첫번째 원소임
    int pivot = start;
    int left = start+1; // 기준인 피벗 이후의 데이터부터 하나씩 확인
    int right = end;
    //printf("start: %d, end: %d, pivot: %d\n",start,end,pivot);
    while (left<=right) {
        // 피벗보다 큰 데이터 찾을 때까지 반복
        while (left<=end && arr[left]<=arr[pivot])
            left++;
        // 피벗보다 작은 데이터 찾을 때까지 반복
        while (right>start && arr[right]>=arr[pivot])
            right--;
        // 정상의 경우 (엇갈리지 않음) => 왼쪽과 오른쪽 교환
        if (left<=right) {
            swap(arr[left],arr[right]);
        }
        // 엇갈린 경우 => 작은 데이터, 피벗 교환
        else {
            swap(arr[pivot],arr[right]);
        }
    }
    /* for (int i=0; i<n; i++) {
        cout<<arr[i]<<" ";
    } */
    //cout<<"완료, 분할 수행 시작\n";
    // 분할 수행 => 재귀적으로
    quickSort(arr, start, right-1);
    quickSort(arr, right+1, end);  
}

int main() {
    cin>>n;
    for (int i=0; i<n; i++){
        cin>>num[i];
    }

    //quickSort(num, 0, n-1);
    sort(num,num+n);
    for (int i=0; i<n; i++) {
        cout<<num[i]<<"\n";
    }
    printf("\n");
    return 0;
}