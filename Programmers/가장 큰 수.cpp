#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;
bool compare(string a, string b) {
    return a+b> b+a;
}

string solution(vector<int> numbers) {
    vector<string> strnum;
    string answer = "";

    for (int x: numbers) {
        string str = to_string(x);
        strnum.push_back(str);
    }
    if (*max_element(numbers.begin(), numbers.end()) == 0){
        answer = "0";
        return answer;
    }
    sort(strnum.begin(), strnum.end(), compare);
    for (string s: strnum) {
        answer += s;
    }

    return answer;
}
