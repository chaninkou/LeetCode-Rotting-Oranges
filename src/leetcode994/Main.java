package leetcode994;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[][] grid = {{2,1,1} ,{1,1,0}, {0,1,1}};
		
		System.out.println("Grid: " + Arrays.deepToString(grid));
		
		FindMinMinuteToRotFunction solution = new FindMinMinuteToRotFunction();
		
		System.out.println("Number of minute to rotten: " + solution.orangesRotting(grid));
		
	}
}
