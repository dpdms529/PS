package Chap3;

//선택정렬

import java.util.*;

public class p1 {

	public static void main(String[] args) {
		int n = 10;
		int[] arr = {7,5,9,0,3,1,6,2,4,8};

		for(int i = 0;i<n;i++) {
			int min = i;
			for(int j = i;j<n;j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		for(int i = 0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
