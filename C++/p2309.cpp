#include <bits/stdc++.h>
#define endl '\n'
using namespace std;
int n[10];
bool f;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int s = 0;
	int x,y;

	for(int i = 0;i<9;i++){
		cin >> n[i];
		s += n[i];
	}
	
	for(int i = 0;i<9;i++){
		for(int j = i+1;j<9;j++){
			if(s-n[i]-n[j] == 100){
				x = i;
				y = j;
				f = true;
			}
		}
		if(f==true){
			break;
		}
	}
	n[x] = 0;
	n[y] = 0;
	sort(n,n+9);
	
	for(int i = 2;i<9;i++){
		cout << n[i] << endl;
	}
	
	return 0;
}
