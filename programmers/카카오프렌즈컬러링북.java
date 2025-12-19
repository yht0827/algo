import java.util.*;

class Solution {

	public int[] solution(int m, int n, int[][] picture) {
		if (picture == null || m <= 0 || n <= 0) {
			return new int[] {0, 0};
		}

		boolean[][] visited = new boolean[m][n];
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int color = picture[i][j];
				if (color == 0 || visited[i][j]) {
					continue;
				}
				int size = dfs(picture, visited, i, j, m, n, color);
				numberOfArea++;
				if (size > maxSizeOfOneArea) {
					maxSizeOfOneArea = size;
				}
			}
		}

		return new int[] {numberOfArea, maxSizeOfOneArea};
	}

	// 깊이우선탐색(DFS)로 연결된 같은 색상의 영역 크기 측정
	private int dfs(int[][] picture, boolean[][] visited,
		int row, int col, int m, int n, int color) {

		if (!inBounds(row, col, m, n))
			return 0;
		if (visited[row][col])
			return 0;
		if (picture[row][col] != color)
			return 0;

		visited[row][col] = true;
		int size = 1;

		// 상하좌우
		size += dfs(picture, visited, row - 1, col, m, n, color);
		size += dfs(picture, visited, row + 1, col, m, n, color);
		size += dfs(picture, visited, row, col - 1, m, n, color);
		size += dfs(picture, visited, row, col + 1, m, n, color);

		return size;
	}

	private boolean inBounds(int i, int j, int m, int n) {
		return i >= 0 && j >= 0 && i < m && j < n;
	}
}
