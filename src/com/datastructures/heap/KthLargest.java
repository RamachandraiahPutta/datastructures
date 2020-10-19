package com.datastructures.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {

	int kthLargest(int[] array, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		for (int i : array) {
			maxHeap.add(i);
		}

		for (int i = 1; i < k; i++) {
			maxHeap.poll();
		}
		return maxHeap.poll();
	}

	public static void main(String args[]) {

		KthLargest ob = new KthLargest();
		int[] array = { 12, 4, 5, 3, 8, 7, 9, 6, 16, 11 };
		int k = 2;
		int result = ob.kthLargest(array, k);
		System.out.println(String.format("%d rd largest value in array is: %d ", k, result));
	}
}
