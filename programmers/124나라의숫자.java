class Solution {
	public static String solution(int n) {
		StringBuilder answer = new StringBuilder();
		String[] trans = {"4", "1", "2"};

		while (n > 0) {
			int reminder = n % 3;
			n /= 3;
			if (reminder == 0)
				n--;
			answer.append(trans[reminder]);
		}
		return answer.reverse().toString();
	}
}