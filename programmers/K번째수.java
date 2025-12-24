import java.util.*;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int len = commands.length;
		int[] answer = new int[len];

		for (int x = 0; x < len; x++) {
			int[] arr = Arrays.copyOfRange(array, commands[x][0] - 1, commands[x][1]);
			Arrays.sort(arr);
			answer[x] = arr[commands[x][2] - 1];
		}

		return answer;
	}
}