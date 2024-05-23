#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    // 1초 동안 소리 강약 체크 수 h
    // 한번 체크한 결과를 저장하는 비트 b
    // 소리를 저장할 트랙 개수인 채널 c
    // 녹음할 시간 s
    double h, b, c, s, storage;
    scanf("%lf %lf %lf %lf", &h, &b, &c, &s);
    storage = h*b*c*s/8/1024/1024;
    printf("%.1lf MB", storage);

    printf("\n\n");
    return 0;
} 