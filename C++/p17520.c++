#include <iostream>
using namespace std;

int main(){
	int n;
	cin >> n;
	int p = n/2;
	int i;
	long long r = 1;
	for(i = 0;i<p;i++){
		r = r * 2 % 16769023;
	}
	if(n%2 != 0){
		r = r * 2 % 16769023;
	}
	cout << r;
	return 0;
	
}
