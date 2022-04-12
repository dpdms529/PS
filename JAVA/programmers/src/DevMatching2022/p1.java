package DevMatching2022;

import java.util.*;
class node implements Comparator<node> {
	int key;
	int value;
	public node(int key, int value) {
		this.key = key;
		this.value = value;
	}
	@Override
	public int compare(node o1, node o2) {
		return o1.value-o2.value;
	}
}

public class p1 {
	
	 public static int[][] solution(int[][] dist) {
        int[][] answer;
        int n = dist.length;
        boolean check[] = new boolean[n];
        for(boolean b : check) {
        	b = true;
        }
        int cnt = 0;
        for(int i = 0;i<n;i++) {
        	int pos[] = dist[i];
        	a : for(int j = 0;j<n;j++) {
        		for(int k = 0;k<n;k++) {
        			if(Math.abs(pos[j]-pos[k]) != dist[j][k]) {
        				check[i] = false;
        				cnt++;
        				break a;
        			}
        		}
        	}
        }
        cnt = n-cnt;
        answer = new int[cnt][n];
        
        for(int i = 0;i<n;i++) {
        	if(check[i]) {
        		int pos[] = dist[i];
        		
        	}
        }
        for(int i = 0;i<cnt;i++) {
        	
        }
        return answer;
    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
