package com.datastructures.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Median: "middle" of a sorted list of numbers. If list is of even size avg of middle 2 elements
 * Ex: L1 = [10, 11, 13, 15, 16, 23, 26] median: 15
 * L2 = [3, 5, 7, 12, 13, 14, 21, 23, 23, 23, 23, 29, 40, 56] median: (21+23)/2 = 22
 * 
 * Given an input stream of n integers, for every element in the stream, 
 * 	a) add element to list
 * 	b) find the median of updated list 
 * 	c) add median to running medians list
 * return running medians list
 * 
 * Input Stream: 12, 4, 5, 3, 8, 7
 * 
 * Output Medians: 12, 8, 5, 4.5, 5, 6
 * 
 * */
public class RunningMedian {

	public double[] runningMedian(int[] array) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		double[] medians = new double[array.length];

		for (int i = 0; i < array.length; i++) {
			addNumber(array[i], maxHeap, minHeap);
			rebalanceHeaps(maxHeap, minHeap);
			medians[i] = getMedian(maxHeap, minHeap);
		}

		return medians;
	}

	private double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
		PriorityQueue<Integer> smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;

		if (biggerHeap.size() == smallerHeap.size()) {
			return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
		} else {
			return biggerHeap.peek();
		}
	}

	private void rebalanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
		PriorityQueue<Integer> smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
		if (biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}
	}

	private void addNumber(int number, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		if (maxHeap.size() == 0 || number < maxHeap.peek()) {
			maxHeap.add(number);
		} else {
			minHeap.add(number);
		}

	}

	public static void main(String args[]) {

		RunningMedian ob = new RunningMedian();
		int[] array = { 12, 4, 5, 3, 8, 7 };
		double[] result = ob.runningMedian(array);
		System.out.println(Arrays.toString(result));
	}
}
