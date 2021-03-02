#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

string mp[26];
bool check[26][26];
int n,cnt;
vector<int> v;
void dfs(int y, int x){
	cnt += 1;
	check[y][x] = true;
	if(y>=0 && x-1>=0 && y<n && x-1<n && check[y][x-1]==false && mp[y][x-1]=='1'){
		dfs(y,x-1);
	}
	if(y>=0 && x+1>=0 && y<n && x+1<n && check[y][x+1]==false && mp[y][x+1]=='1'){
		dfs(y,x+1);
	}
	
	if(y-1>=0 && x>=0 && y-1<n && x<n && check[y-1][x]==false && mp[y-1][x]=='1'){
		dfs(y-1,x);
	}
	if(y+1>=0 && x>=0 && y+1<n && x<n && check[y+1][x]==false && mp[y+1][x]=='1'){
		dfs(y+1,x);
	}
	
}

int main()
{
   ios_base::sync_with_stdio(false);
   cin .tie(NULL);
   cout.tie(NULL);
   
   cin >> n;
   for(int i = 0;i<n;i++){
   		cin >> mp[i]; 
   }
	for(int i = 0;i<n;i++){
		for(int j = 0;j<n;j++){
   			if(mp[i][j] == '1' && check[i][j] == false){
   				cnt = 0;
				dfs(i,j);
				v.push_back(cnt);
			}
		}
   }
   sort(v.begin(),v.end());
   cout << v.size() << endl;
   for(int i = 0;i<v.size();i++){
		cout << v[i] << endl;
   }
   
   return 0;
}
