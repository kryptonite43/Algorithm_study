#include <string>
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int solution(string s) {
    int minimum = s.size();

    for (int i=1; i<=s.length()/2; i++) {
        vector<string> v;
        string result = "";
        int cnt = 1;

        for (int j=0; j<s.length(); j+=i) {
            string tmp = s.substr(j, i);
            v.push_back(tmp);
        }

        for (int j=1; j<v.size(); j++) {
            if (!v[j].compare(v[j-1])) { // ���� ���ڿ��� ������
                cnt++;
            }
            else { // ���� ���ڿ��� �ٸ� �� -> 1. �ݺ� ���� 2. �ݺ��� �� ����
                
                if (cnt == 1) { // �ݺ� ���� ���ڿ�
                    result += v[j-1]; // ���� ���ڿ��� �������� ����
                }
                else { // �ݺ� ����
                    string tmp1;
                    tmp1 = to_string(cnt);
                    result = result +tmp1+v[j-1];
                    cnt = 1;
                }
            }
            if (j==v.size()-1) {
                if (cnt==1)
                    result += v[j];
                else {
                    string tmp2;
                    tmp2 = to_string(cnt);
                    result = result+tmp2+v[j];
                }
            }
        }
        minimum = min(minimum, static_cast<int>(result.size()));
    }
    return minimum;
}

int main() {
    string str;
    cin>>str;
    cout<<solution(str);
    printf("\n\n");
    return 0;
}