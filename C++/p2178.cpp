#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

string miro[101];
int dy[] = {0,0,-1,1};
int dx[] = {-1,1,0,0};
bool check[101][101];

int main()
{
   ios_base::sync_with_stdio(false);
   cin .tie(NULL);
   cout.tie(NULL);
   int n,m;
   cin >> n>> m;
   for(int i = 0;i<n;i++)
		cin>>miro[i];
	queue<pair<int,int> > q;
	q.push({0,0});
	int cnt = 0;
	while(!q.empty()){
		cnt++;
		int size = q.size();
		while(size--){
			int y = q.front().first, x = q.front().second;
			if(y == n-1 && x == m-1){
				cout << cnt;
				return 0;
			}
			q.pop();
			for(int i = 0;i<4;i++){
				int ny = y + dy[i], nx = x + dx[i];
				if(ny<n && nx<m && ny>=0 && check[ny][nx] == false && miro[ny][nx] == '1'){
					q.push({ny,nx});
					check[ny][nx] = true;
				}
				
			
			}	
		}
		
		
	}	

   return 0;
}
