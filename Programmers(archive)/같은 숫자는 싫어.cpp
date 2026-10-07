#include <vector>
#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    stack<int> st;
    int cur, last;

    for (int x: arr) {
        if (st.empty()) {
            st.push(x);
            continue;
        }
        last = st.top();
        if (last != x) {
            st.push(x);
        }
    }
    while (!st.empty()) {
        cur = st.top();
        st.pop();
        answer.push_back(cur);
    }
    reverse(answer.begin(), answer.end());

    return answer;
}