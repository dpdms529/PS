#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

bool check[55][55];
bool mp[55][55];
int m,n;


void dfs(int y, int x){
	check[y][x] = true;
	if(y>=0 && x-1>=0 && y<n && x-1<m && check[y][x-1]==false && mp[y][x-1]==true){
		dfs(y,x-1);
	}
	if(y>=0 && x+1>=0 && y<n && x+1<m && check[y][x+1]==false && mp[y][x+1]==true){
		dfs(y,x+1);
	}
	
	if(y-1>=0 && x>=0 && y-1<n && x<m && check[y-1][x]==false && mp[y-1][x]==true){
		dfs(y-1,x);
	}
	if(y+1>=0 && x>=0 && y+1<n && x<m && check[y+1][x]==false && mp[y+1][x]==true){
		dfs(y+1,x);
	}
	
}

int main()
{
   ios_base::sync_with_stdio(false);
   cin .tie(NULL);
   cout.tie(NULL);
   
   int t;
   cin >> t;
   while(t--){
   	int cnt = 0;
   	int k;
   	cin >> m >> n >> k;
   	memset(mp,false,sizeof(mp));
   	memset(check,false,sizeof(check));
   	for(int i = 0;i<k;i++){
   		int a,b;
   		cin >> a >> b;
   		mp[b][a] = true;
	   }
	   for(int i = 0;i<n;i++){
	   	for(int j = 0;j<m;j++){
	   		if(check[i][j] == false && mp[i][j] == true){
	   			cnt++;
		   		dfs(i,j);
			   }
		   	
		   }
	   }
	   cout << cnt << endl;
   }
   
   
   return 0;
}
