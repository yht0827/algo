class Solution {
	public int solution(String s) {
		int answer = 0;

		char x = 0;
		int cntSame = 0;
		int cntDiff = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (cntSame == 0 && cntDiff == 0) {
				x = ch;
			}

			if (ch == x) {
				cntSame++;
			} else {
				cntDiff++;
			}

			if (cntSame == cntDiff) {
				answer++;
				cntSame = 0;
				cntDiff = 0;
			}

		}

		if (cntSame != 0 || cntDiff != 0) {
			answer++;
		}

		return answer;
	}
}