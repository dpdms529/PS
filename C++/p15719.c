#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n,s,t=0;
	int sum = 0;
	cin >> n;
	for(int i = 0;i<n;i++){
		cin >> s;
		sum += s;
	}
	for(int i = 1;i<n;i++){
		t += i;
	}

	cout << sum - t;
	
	return 0;
}
