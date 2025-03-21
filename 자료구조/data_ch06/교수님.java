package data_ch06;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class 교수님 {


	private static void quickSortStack(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}

		int low = 0;
		int high = arr.length - 1;

		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] { low, high });

		while (!stack.isEmpty()) {
			int[] bounds = stack.pop();
			low = bounds[0];
			high = bounds[1];

			if (low < high) {
				int pi = partition(arr, low, high);
				if (pi - 1 > low) {
					stack.push(new int[] { low, pi - 1 });
				}

				if (pi + 1 < high) {
					stack.push(new int[] { pi + 1, high });
				}
			}
		}
	}

	private static int partition(int[] arr, int low, int high) {
		Random rand = new Random();
		int pivotIndex = low + rand.nextInt(high - low + 1);
		int pivot = arr[pivotIndex];
		swap(arr, pivotIndex, high);

		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
        
        // Random Array generator
        // int[] rawArray = IntStream.generate(() -> new Random().nextInt(1000)).limit(1000).toArray();        
        // quickSort(rawArray, 0, rawArray.length-1);

        int[] sortedArr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("정렬 전 배열 : " + Arrays.toString(sortedArr));
//        quickSort(sortedArr, 0, sortedArr.length-1);
        quickSortStack(sortedArr);
        System.out.println("정렬 후 배열 : " + Arrays.toString(sortedArr));
        
        int[] rSortedArr = {10,9,8,7,6,5,4,3,2,1};
        System.out.println("정렬 전 배열 : " + Arrays.toString(rSortedArr));
//         quickSort(rSortedArr, 0, rSortedArr.length-1);
         quickSortStack(rSortedArr);
        System.out.println("정렬 후 배열 : " + Arrays.toString(rSortedArr));

        int[] duplicatedArr = {10,10,10,10,10,5,1,1,1};
        System.out.println("정렬 전 배열 : " + Arrays.toString(duplicatedArr));
//        quickSort(duplicatedArr, 0, duplicatedArr.length-1);
        quickSortStack(duplicatedArr);
        System.out.println("정렬 후 배열 : " + Arrays.toString(duplicatedArr));

        int[] emptyArr = {};
        System.out.println("정렬 전 배열 : " + Arrays.toString(emptyArr));
//        quickSort(emptyArr, 0, emptyArr.length-1);
        quickSortStack(emptyArr);
        System.out.println("정렬 후 배열 : " + Arrays.toString(emptyArr));

        int[] singleElementArr = {1};
        System.out.println("정렬 전 배열 : " + Arrays.toString(singleElementArr));
//        quickSort(singleElementArr, 0, singleElementArr.length-1);
        quickSortStack(singleElementArr);
        System.out.println("정렬 후 배열 : " + Arrays.toString(singleElementArr));
    }
}
