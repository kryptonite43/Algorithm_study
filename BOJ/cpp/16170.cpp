#include <iostream>
#include <cstdio>
#include <ctime>
using namespace std;

int main() {
    time_t timer = time(NULL); // 1970.01.01 00:00:00 기점으로 현재까지 흐른 시간 (초 단위)
    struct tm* t = gmtime(&timer); // tm 구조체를 활용하여 원하는 형태로 변환
    
    cout<<t->tm_year + 1900<<"\n";
    cout<<t->tm_mon + 1<<"\n";
    cout<<t->tm_mday;

    printf("\n\n");
    return 0;
}