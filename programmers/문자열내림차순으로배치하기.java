import java.util.*;

class Solution {
	public String solution(String s) {

		int[] lower = new int[26];
		int[] upper = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				upper[ch - 'A']++;
			else if (ch >= 'a' && ch <= 'z')
				lower[ch - 'a']++;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 25; i >= 0; i--) {
			while (lower[i]-- > 0)
				sb.append((char)('a' + i));
		}

		for (int i = 25; i >= 0; i--) {
			while (upper[i]-- > 0)
				sb.append((char)('A' + i));
		}

		return sb.toString();
	}
}