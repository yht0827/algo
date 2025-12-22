class Solution {
	private boolean[] visited;

	public int solution(int n, int[][] computers) {
		visited = new boolean[n];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i, computers);
				answer++;
			}
		}
		return answer;
	}

	private void dfs(int num, int[][] computers) {
		visited[num] = true;

		for (int i = 0; i < computers.length; i++) {
			if (computers[num][i] == 1 && !visited[i]) {
				dfs(i, computers);
			}
		}
	}
}