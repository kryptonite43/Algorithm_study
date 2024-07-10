#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;

int n;
int num[1000010] = {0};

void quickSort(int* arr, int start, int end) {
    // ���Ұ� 1���� ����
    if (start>=end) return;
    // �ǹ��� ù��° ������
    int pivot = start;
    int left = start+1; // ������ �ǹ� ������ �����ͺ��� �ϳ��� Ȯ��
    int right = end;
    //printf("start: %d, end: %d, pivot: %d\n",start,end,pivot);
    while (left<=right) {
        // �ǹ����� ū ������ ã�� ������ �ݺ�
        while (left<=end && arr[left]<=arr[pivot])
            left++;
        // �ǹ����� ���� ������ ã�� ������ �ݺ�
        while (right>start && arr[right]>=arr[pivot])
            right--;
        // ������ ��� (�������� ����) => ���ʰ� ������ ��ȯ
        if (left<=right) {
            swap(arr[left],arr[right]);
        }
        // ������ ��� => ���� ������, �ǹ� ��ȯ
        else {
            swap(arr[pivot],arr[right]);
        }
    }
    /* for (int i=0; i<n; i++) {
        cout<<arr[i]<<" ";
    } */
    //cout<<"�Ϸ�, ���� ���� ����\n";
    // ���� ���� => ���������
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