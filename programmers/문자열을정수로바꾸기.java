class Solution {
	public int solution(String s) {
		char first = s.charAt(0);
		int start = 0;
		int sign = 1;

		if (first == '-') {
			sign = -1;
			start = 1;
		} else if (first == '+') {
			start = 1;
		}

		int answer = 0;
		for (int i = start; i < s.length(); i++) {
			answer = answer * 10 + (s.charAt(i) - '0');
		}

		return sign * answer;
	}
}