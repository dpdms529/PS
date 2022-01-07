import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class p1931 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int arr[][] = new int[n][2];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] obj1, int[] obj2) {
				if(obj1[1] == obj2[1]) return obj1[0] - obj2[0];
				else return obj1[1] - obj2[1];
			}
		});
		
		int pre = 0, cnt = 0;
		for(int i = 0;i<n;i++) {
			if(arr[i][0] >= pre) {
				cnt++;
				pre = arr[i][1];
			}
		}
		System.out.println(cnt);
	}

}

//public static void main(String[] args)throws IOException {
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//int n = Integer.parseInt(br.readLine());
//StringTokenizer st;
//int start[] = new int[n];
//int end[] = new int[n];
//HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
//for(int i = 0;i<n;i++) {
//	st = new StringTokenizer(br.readLine());
//	start[i] = Integer.parseInt(st.nextToken());
//	end[i] = Integer.parseInt(st.nextToken());
//	hm.put(i, new ArrayList<Integer>(Arrays.asList(end[i],start[i])));
//}
//ArrayList<Entry<Integer,ArrayList<Integer>>> entryList = new ArrayList<>(hm.entrySet());
//Collections.sort(entryList, new Comparator<Entry<Integer,ArrayList<Integer>>>(){
//	public int compare(Entry<Integer,ArrayList<Integer>> obj1, Entry<Integer,ArrayList<Integer>> obj2) {
//		if(obj1.getValue().get(0).compareTo(obj2.getValue().get(0)) == 0)
//			return obj1.getValue().get(1).compareTo(obj2.getValue().get(1));
//		else return obj1.getValue().get(0).compareTo(obj2.getValue().get(0));
//	}
//});
//
//int cnt = 1;
//int preIndex = entryList.get(0).getKey();
//int preEnd = end[preIndex];
//for(int i = 1;i<n;i++) {
//	int index = entryList.get(i).getKey();
//	if(start[index]>=preEnd) {
//		cnt++;
//		preIndex = index;
//		preEnd = end[index];
//	}
//}
//System.out.println(cnt);
//}
