package counting.groups;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

	static int[] countGroups(int[][] m, int[] t) {
		Map<Integer, Integer> groupSizeMap = new HashMap<Integer, Integer>();
		int ROWS = m.length;
		int COLUMNS = m[0].length;
		int[] result = new int[t.length];
		boolean[][] visited = new boolean[ROWS][COLUMNS];
		for (int row = 0; row < ROWS; row++) {
			int count =0;
			for (int col = 0; col < COLUMNS; col++) {
				if (!visited[row][col] && m[row][col] == 1) {
					count+=	findGroups(visited, new Cell(row, col), m);
				}
			}
			if(groupSizeMap.containsKey(count)){
				groupSizeMap.put(count, groupSizeMap.get(count)+1);
			}
			else{
				groupSizeMap.put(count,1);
			}
		}
		for (int q = 0; q < t.length; q++) {
			result[q] = groupSizeMap.get(t[q]) == null ? 0 : groupSizeMap.get(t[q]);
		}
		return result;
	}

	private static int findGroups(boolean[][] visited, Cell source, int[][] m) {
		Queue<Cell> queue = new LinkedList<Cell>();
		visited[source.x][source.y] = true;
		queue.add(source);
		int maxQueueSize = 0;
		while (!queue.isEmpty()) {
			Cell ptr = queue.poll();
			addValidNodes(queue, visited, ptr, m);
			maxQueueSize=maxQueueSize+1;
		}
		return maxQueueSize;
	}

	private static void addValidNodes(Queue<Cell> queue, final boolean[][] visited, Cell ptr, int[][] m) {
		int row = ptr.x;
		int col = ptr.y;


		addIfValidGroup(queue, visited, row, col - 1,m);
		addIfValidGroup(queue, visited, row, col + 1,m);

		addIfValidGroup(queue, visited, row - 1, col,m);
		addIfValidGroup(queue, visited, row + 1, col,m);
	}

	private static void addIfValidGroup(final Queue<Cell> queue, final boolean[][] visited, final int row,
			final int col, final int[][] m) {
		if (isValidCoordinates(row,col,m)) {
			if (m[row][col] == 1 && !visited[row][col]) {
				Cell node = new Cell(row, col);
				visited[row][col] = true;
				queue.add(node);
			}
		}
	}

	private static boolean isValidCoordinates(final int row, final int col,int[][]m)
	{
		return row >= 0 && row < m.length && col >= 0 && col < m[0].length;
	}

	private static class Cell {
		int x;
		int y;

		Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


	public static void main(String[] args) {
		int m[][]= {  	  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						  {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
						  {1, 1, 1, 0, 0, 0, 0, 1, 1, 1},
						  {1, 1, 0, 0, 6, 0, 0, 1, 1, 1},
						  {1, 0, 1, 0, 0, 1, 1, 0, 0, 0},
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

		};
		int[] t={1,10,20,2,6};
		int[] res = countGroups(m, t);
		printResult(res);

		int m1[][]= {{1, 0, 1, 1, 0},
				{0, 1, 0, 0, 1},
				{1, 0, 1, 1, 0},
				{1, 0, 1, 1, 0},
				{0, 1, 0, 0, 1}};
		int[] t1={1,2,3,4,5};
		res = countGroups(m1, t1);
		printResult(res);
	}

	private static void printResult(int[] res) {
		System.out.println("Output");
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}

}
