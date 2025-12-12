import java.util.*;

class Solution {
	private int n;
	private int m;
	private int[][] land;
	private boolean[][] visited;
	private int[][] clusterId;
	private final int[] dx = {1, -1, 0, 0};
	private final int[] dy = {0, 0, 1, -1};

	public int solution(int[][] land) {
		this.land = land;
		this.n = land.length;
		this.m = land[0].length;
		this.visited = new boolean[n][m];
		this.clusterId = new int[n][m];

		int nextId = 0;
		Map<Integer, Integer> sizeById = new HashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (land[i][j] == 1 && !visited[i][j]) {
					int size = bfsMarkCluster(i, j, nextId);
					sizeById.put(nextId, size);
					nextId++;
				}
			}
		}

		int maxOil = 0;
		for (int col = 0; col < m; col++) {
			int total = sumColumnClusters(col, sizeById);
			if (total > maxOil) {
				maxOil = total;
			}
		}
		return maxOil;
	}

	private int bfsMarkCluster(int sx, int sy, int id) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx, sy});
		visited[sx][sy] = true;
		clusterId[sx][sy] = id;
		int size = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (land[nx][ny] == 0 || visited[nx][ny])
					continue;
				visited[nx][ny] = true;
				clusterId[nx][ny] = id;
				q.offer(new int[] {nx, ny});
				size++;
			}
		}
		return size;
	}

	private int sumColumnClusters(int col, Map<Integer, Integer> sizeById) {
		int total = 0;
		Set<Integer> seen = new HashSet<>();
		for (int row = 0; row < n; row++) {
			if (land[row][col] == 1) {
				int id = clusterId[row][col];
				if (seen.add(id)) {
					total += sizeById.get(id);
				}
			}
		}
		return total;
	}
}
