import java.util.*;

class Solution {
	public String solution(String s, String skip, int index) {
		boolean[] blocked = new boolean[26];
		for (int i = 0; i < skip.length(); i++) {
			blocked[skip.charAt(i) - 'a'] = true;
		}
		StringBuilder sb = new StringBuilder(s.length());
		for (int i = 0; i < s.length(); i++) {
			int cur = s.charAt(i) - 'a';
			int moved = 0;
			while (moved < index) {
				cur = (cur + 1) % 26;
				if (!blocked[cur])
					moved++;
			}
			sb.append((char)(cur + 'a'));
		}
		return sb.toString();
	}
}
