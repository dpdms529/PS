package bucketplace2022;

import java.util.*;

class node{
	char dir;
	int cnt;
	public node(char dir, int cnt) {
		this.dir = dir;
		this.cnt = cnt;
	}
}

public class p1 {
	
	public static String[] solution(String path) {
		ArrayList<node> list = new ArrayList<>();
		char c = path.charAt(0);
		int cnt = 0;
		for(int i = 0;i<path.length();i++) {
			if(c == path.charAt(i)) {
				cnt++;
			}else {
				list.add(new node(c, cnt));
				c = path.charAt(i);
				cnt = 1;
			}
			if(i == path.length()-1) {
				list.add(new node(c, cnt));
				c = path.charAt(i);
			}
		}
		String[] answer = new String[list.size()-1];
		int time = 0;
		for(int i = 0;i<list.size()-1;i++) {
			char currentDir = list.get(i).dir;
			char nextDir;
			String changeDir = "";
			nextDir = list.get(i+1).dir;
			if(currentDir == 'E') {
				switch(nextDir) {
				case 'N':
					changeDir = "left";
					break;
				case 'S':
					changeDir = "right";
					break;
				}
			}else if(currentDir == 'S') {
				switch(nextDir) {
				case 'E':
					changeDir = "left";
					break;
				case 'W':
					changeDir = "right";
					break;
				}
			}else if(currentDir == 'W') {
				switch(nextDir) {
				case 'S':
					changeDir = "left";
					break;
				case 'N':
					changeDir = "right";
					break;
				}
			}else if(currentDir == 'N') {
				switch(nextDir) {
				case 'W':
					changeDir = "left";
					break;
				case 'E':
					changeDir = "right";
					break;
				}
			}
			cnt = list.get(i).cnt;
			if(cnt>5) {
				time += cnt-5;
				cnt = 5;
			}
			String s = "Time " + time + ": Go straight " + (cnt*100) + "m and turn " + changeDir;
			answer[i] = s;
			time += cnt;
		}
		return answer;
	}
	public static void main(String[] args) {
		String[] result = solution("SSSSSSWWWNNNNNN");
		for(int i = 0;i<result.length;i++) {
			System.out.println(result[i]);
		}
		
	}

}
