package com.datastructures.graph;

import java.util.Objects;

public class NumOfIslands {

	public static int numOfIslands(int[][] graph) {
		if (Objects.isNull(graph) || graph.length == 0 || graph[0].length == 0)
			return 0;

		int rows = graph.length;
		int columns = graph[0].length;
		int components = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (graph[i][j] == 1) {
					components++;
					markVisitedNodes(graph, i, j);
				}
			}
		}

		return components;
	}

	public static void markVisitedNodes(int[][] graph, int row, int column) {
		int rows = graph.length;
		int columns = graph[0].length;
		if (row < 0 || row >= rows || column < 0 || column >= columns || graph[row][column] == 0)
			return;
		graph[row][column] = 0;
		markVisitedNodes(graph, row - 1, column);
		markVisitedNodes(graph, row + 1, column);
		markVisitedNodes(graph, row, column - 1);
		markVisitedNodes(graph, row, column + 1);

	}

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };

		System.out.println(numOfIslands(graph));

		int graph2[][] = new int[][] { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		System.out.println(numOfIslands(graph2));

		int graph3[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
		System.out.println(numOfIslands(graph3));

	}
}
