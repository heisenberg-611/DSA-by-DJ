#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define nl '\n'

int solve(int n) {
    int r = 1;
    while (n != 1) {
        if (n % 2 == 0) {
            n /= 2;
        } else {
            n = 3 * n + 1;
        }
        r++;
    }
    return r;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int i, j;
    while (cin >> i >> j) {
        int mx = 0;
        for (int k = min(i, j); k <= max(i, j); k++) {
            mx = max(mx, solve(k));
        }
        cout << i << " " << j << " " << mx << nl;
    }
    
    return 0;
}