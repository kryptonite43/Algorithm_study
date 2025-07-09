#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

int main() {
    int n;
    string word;
    int alpha[30]={0,};
    char prev, cur;
    int grpword = 0;

    cin>>n;
    for (int i=0; i<n; i++) {
        cin >> word;
        if (word.size()==1){
            grpword++;
            //printf("�׷� �ܾ�: %s\n", word.c_str());
            continue;
        }
        prev = word[0];
        alpha[prev-'a']++;
        
        for (int j = 1; j < word.size(); j++) {
            cur = word[j];
            if (prev != cur) {
                if (alpha[cur - 'a']!= 0)
                    break;
            }
            alpha[cur - 'a']++;
            prev = word[j];
            if (j == word.size()-1) { // �Ǻ� �Ϸ�
                grpword++;
                //printf("�׷� �ܾ�: %s\n", word.c_str());
            }
        }
        fill_n(alpha,30,0);
    }

    printf("%d\n\n", grpword);
    return 0;
}