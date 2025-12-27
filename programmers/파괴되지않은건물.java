class Solution {
	public int solution(int[][] board, int[][] skill) {
		int answer = 0;

		int n = board.length;
		int m = board[0].length;
		int[][] sum = new int[n + 1][m + 1];

		for (int[] s : skill) {
			int type = s[0];
			int r1 = s[1];
			int c1 = s[2];
			int r2 = s[3];
			int c2 = s[4];

			int degree = (type == 1) ? -s[5] : s[5];

			for (int i = r1; i <= r2; i++) {
				sum[i][c1] += degree;
				sum[i][c2 + 1] -= degree;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (j != 0)
					sum[i][j] += sum[i][j - 1];
				board[i][j] += sum[i][j];
				if (board[i][j] > 0) {
					answer++;
				}
			}
		}

		return answer;
	}
}