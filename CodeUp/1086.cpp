#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    // 가로 w, 세로 h, 비트 b
    double w, h, b, volume;
    scanf("%lf %lf %lf", &w, &h, &b);
    volume = w * h * b / 8 / 1024 / 1024;
    printf("%.2lf MB", volume);
    printf("\n\n");
    return 0;
}