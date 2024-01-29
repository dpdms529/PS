package Sorting;

import java.util.Arrays;

public class QuickSort {
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // 파티션 인덱스를 구함, arr[pi]는 이제 정확한 위치에 있음
            int pi = partition(arr, low, high);

            // 재귀적으로 왼쪽과 오른쪽 부분 배열을 정렬
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // 퀵 정렬의 핵심인 파티션 함수
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low; // 작은 원소의 인덱스
        for (int j = low; j < high; j++) {
            // 현재 원소가 피벗보다 작거나 같으면 교환
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // 피벗을 교환하여 피벗의 최종 위치를 확정
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[] array = {3,6,1,2,7,9,8,5,4};
        quickSort(array, 0,8);
        System.out.println(Arrays.toString(array));
    }
}
