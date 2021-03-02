#include <bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin >> n;
	
	vector<int> v(n);
	for(int i = 0;i<n;i++){
		int t;
		cin >> t;
		v[i] = t;
	}
	sort(v.begin(),v.end());
	for(int i = 0;i<n;i++){
		cout << v[i] << endl;
	}
	return 0;
}
