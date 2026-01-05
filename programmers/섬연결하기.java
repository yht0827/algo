import java.util.*;

class Solution {
	private void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y)
			parent[y] = x;
	}

	private int find(int x) {
		if (x == parent[x])
			return x;

		return find(parent[x]);
	}

	private int[] parent;

	public int solution(int n, int[][] costs) {
		parent = new int[n];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
		int edges = 0;
		int answer = 0;

		for (int[] cost : costs) {
			if (edges == n - 1) {
				break;
			}

			if (find(cost[0]) != find(cost[1])) {
				union(cost[0], cost[1]);
				answer += cost[2];
				edges++;
			}

		}

		return answer;
	}
}