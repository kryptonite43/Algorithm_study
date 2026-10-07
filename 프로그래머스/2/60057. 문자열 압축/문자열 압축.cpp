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
        /* for (int j=0; j<v.size();j++) {
            cout<<v[j]<<endl;
        } */

        //cout<<"시작\n";
        for (int j=1; j<v.size(); j++) {
            //printf("v[%d]=%s, v[%d]=%s, cnt=%d, result=%s\n",j-1,v[j-1].c_str(), j,v[j].c_str(), cnt, result.c_str());
            if (!v[j].compare(v[j-1])) { // 이전 문자열과 같으면
                cnt++;
                //cout<<"이전문자열과 같다\n";
            }
            else { // 이전 문자열과 다를 때 -> 1. 반복 끊김 2. 반복한 적 없음
                
                if (cnt == 1) { // 반복 없는 문자열
                    //cout<<"반복이 없음\n";
                    result += v[j-1]; // 이전 문자열을 최종으로 저장
                }
                else { // 반복 끊김
                    //cout<<"반복이 끊김\n";
                    string tmp1;
                    tmp1 = to_string(cnt);
                    result = result +tmp1+v[j-1];
                    //if (j != v.size()-1)
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
                    //printf("최종. v[%d]=%s, v[%d]=%s, cnt=%d, result=%s\n",j-1,v[j-1].c_str(), j,v[j].c_str(), cnt, result.c_str());
            }
            
        }
        minimum = min(minimum, static_cast<int>(result.size()));
        //cout<<"끝\n";

    }
    return minimum;
}