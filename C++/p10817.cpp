#include <bits/stdc++.h>
using namespace std;

int main(){
	vector<int> v;
	for(int i = 0;i<3;i++){
		int n;
		cin >> n;
		v.push_back(n);
	}
	
	int m;
	
	for(int i = 0;i<2;i++){
		m = i;
		for(int j = i+1;j<3;j++){
			if(v[m]>v[j]){
				m = j;
			}
		}
		int t = v[i];
		v[i] = v[m];
		v[m] = t;
	}
	
	cout << v[1];
	
	return 0;
}
