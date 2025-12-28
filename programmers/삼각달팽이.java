// Solution.java

import java.util.*;

class Solution {
	public int[] solution(int n) {
		int total = n * (n + 1) / 2;
		int[][] arr = new int[n][n];
		int num = 1;
		int r = -1, c = 0;

		for (int k = n; k > 0; k -= 3) {
			for (int i = 0; i < k; i++) {
				r += 1;
				arr[r][c] = num++;
			}
			if (num > total)
				break;

			int rightSteps = Math.max(0, k - 1);
			for (int i = 0; i < rightSteps; i++) {
				c += 1;
				arr[r][c] = num++;
			}
			if (num > total)
				break;

			int upDiagSteps = Math.max(0, k - 2);
			for (int i = 0; i < upDiagSteps; i++) {
				r -= 1;
				c -= 1;
				arr[r][c] = num++;
			}
		}

		int[] answer = new int[total];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[idx++] = arr[i][j];
			}
		}
		return answer;
	}
}
