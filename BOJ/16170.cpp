#include <iostream>
#include <cstdio>
#include <ctime>
using namespace std;

int main() {
    time_t timer = time(NULL); // 1970.01.01 00:00:00 �������� ������� �帥 �ð� (�� ����)
    struct tm* t = gmtime(&timer); // tm ����ü�� Ȱ���Ͽ� ���ϴ� ���·� ��ȯ
    
    cout<<t->tm_year + 1900<<"\n";
    cout<<t->tm_mon + 1<<"\n";
    cout<<t->tm_mday;

    printf("\n\n");
    return 0;
}