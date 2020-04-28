package leetcode994;

import java.util.LinkedList;
import java.util.Queue;

public class FindMinMinuteToRotFunction {
	public int orangesRotting(int[][] grid) {
		// Edge case
		if (grid.length == 0 || grid == null) {
			return 0;
		}

		int row = grid.length;

		int col = grid[0].length;

		int numberOfFresh = 0;

		// -1 since for first loop, we check for first minute
		int totalMinute = -1;

		// queue to keep track of each rotten orange for each minute
		Queue<int[]> queue = new LinkedList<>();

		// This is very smart way to go all four direction for one time
		int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// Store all the position for rotten orange 
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					numberOfFresh++;
				}
			}
		}

		// If there is no fresh orange
		if (numberOfFresh == 0) {
			return 0;
		}

		// For each minute, turn everything next to 2 to 2
		while (!queue.isEmpty()) {
			int size = queue.size();

			totalMinute++;

			for (int i = 0; i < size; i++) {
				int[] currentRot = queue.poll();

				// For all 4 direction
				for (int[] dir : direction) {
					// x and y is the new position we checking
					int x = currentRot[0] + dir[0];
					int y = currentRot[1] + dir[1];

					// Fail case to prevent overflow or not fresh orange
					if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0 || grid[x][y] == 2) {
						continue;
					}

					grid[x][y] = 2;

					// Add the rotten to the queue now
					queue.offer(new int[] { x, y });

					numberOfFresh--;
				}
			}
		}

		// -1 means orange impossible to get rotten
		return numberOfFresh == 0 ? totalMinute : -1;
	}
}
