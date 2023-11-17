import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class assignment_2 {
	static List<Integer> findDublicates(List<Integer> list) {
		Map<Integer, Integer> dub = new HashMap<>();
		List<Integer> dublicates = new ArrayList<>();
		for (Integer i : list) {
			dub.put(i, dub.getOrDefault(i, 0) + 1);
		}
		for (Integer key : dub.keySet()) {
			if (dub.get(key) > 1)
				dublicates.add(key);
		}
		return dublicates;
	}

	static int partition(int a[], int start, int end) {
		int pivot = a[end];
		int i = (start - 1);

		for (int j = start; j <= end - 1; j++) {
			if (a[j] < pivot) {
				i++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		int t = a[i + 1];
		a[i + 1] = a[end];
		a[end] = t;
		return (i + 1);
	}

	static void quicksort(int a[], int start, int end) {
		if (start < end) {
			int p = partition(a, start, end); // p is partitioning index
			quicksort(a, start, p - 1);
			quicksort(a, p + 1, end);
		}
	}

	static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}

	}

	static void mergesort(int a[], int l, int r) {

		if (l < r) {
			int mid = l + (r - l) / 2;
			mergesort(a, l, mid);
			mergesort(a, mid + 1, r);
			merge(a, l, mid, r);
		}
	}

	 static void merge(int[] a, int l, int mid, int r) {
		int a1[] = new int[mid - l + 1];
		int a2[] = new int[r - mid];

		for (int i = l; i <= mid; i++) {
			a1[i - l] = a[i];
		}

		for (int i = mid + 1; i <= r; i++) {
			a2[i - mid - 1] = a[i];
		}

		int i = 0, j = 0, k = l;

		while (i < a1.length && j < a2.length) {
			if (a1[i] <= a2[j])
				a[k++] = a1[i++];
			else
				a[k++] = a2[j++];
		}
		while (i < a1.length)
			a[k++] = a1[i++];
		while (j < a2.length)
			a[k++] = a2[j++];
	}

	 static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
			}
			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
	}
	static boolean isArraySubset(int[] array1,int [] array2) {
		//returns true if array1 is subset of array2
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
		
        for(int i:array1)set1.add(i);
		for(int i:array2)set2.add(i);
		
		for(Integer i:set1)if(!set2.contains(i)) return false;
		
		return true;
		
	}
	
	 
	

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1, 2, 2, 4, 5, -1, 3, -1, 7);
		int[] unsorted = { 1, 4, 7, 5, 4, 3, 1, -2, 14, -3, 8 };
		int[] unsorted1 = { 1, 4, 7, 5, 4, 3, 1, -2, 14, -3, 8 };
		int[] unsorted2 = { 1, 4, 7, 5, 4, 3, 1, -2, 14, -3, 8 };
		int[] unsorted3 = { 1, 4, 7, 5, 4, 3, 1, -2, 14, -3, 8 };
		
		int[] arr1= {1,2,3};
		int[] arr2= {1,2,3,4,5,6};

		System.out.println(findDublicates(l));

		quicksort(unsorted, 0, 10);

		for (int i : unsorted)
			System.out.print(i + " ");

		System.out.println();

		bubbleSort(unsorted1);

		for (int i : unsorted1)
			System.out.print(i + " ");

		System.out.println();

		mergesort(unsorted2, 0, 10);

		for (int i : unsorted2)
			System.out.print(i + " ");
		
		System.out.println();
		
		selectionSort(unsorted3);
		for (int i : unsorted3)
			System.out.print(i + " ");
		
		System.out.println();
		
		System.out.println("arr1 is subset of arr2--> "+isArraySubset(arr1,arr2));

	}

}
