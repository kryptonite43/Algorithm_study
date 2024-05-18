#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

int main()
{
    int n = 0, ans = 0, bulk = 0;
    cin >> n;

    for (int min = 0; min < 60; min++)
    {
        for (int sec = 0; sec < 60; sec++)
        {
            string s = to_string(min) + to_string(sec);
            if (s.find("3") != string::npos)
                bulk++;
        }
    }

    for (int i = 0; i <= n; i++)
    {
        if (i == 3 || i == 13 || i == 23)
        {
            ans += 3600;
            continue;
        }
        ans += bulk;
    }

    printf("%d\n\n", ans);
    return 0;
}

// 스위치문에 들어가는 case에는 숫자만 가능함