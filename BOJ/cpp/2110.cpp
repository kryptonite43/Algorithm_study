#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;
vector<int> house, dist;

int binarySearch(int target, int start, int end) {
    int mid;
    while (start<end) {
        mid = (start+end)/2;
        int cnt = 1, last = house[0];

        // canInstall?
        for (int i=1; i<house.size(); i++) {
            if (house[i]-last >= mid) { 
                cnt++;
                last = house[i];
            }
        }
        //

        if (cnt >= target) {
            start = mid+1; 
        }   
        else { // cnt < target 
            end = mid; 
        }
    }
    return start-1;
}

int main() {
    int n, c;
    

    cin>>n>>c;
    for (int i=0; i<n; i++) {
        int x;
        cin>>x;
        house.push_back(x);
    }
    sort(house.begin(), house.end());
    int maxdist = house[house.size()-1]-house[0]+1;
    cout<<binarySearch(c, 1, maxdist);
    printf("\n");
    return 0;
}