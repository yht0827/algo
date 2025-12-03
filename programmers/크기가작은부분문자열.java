import java.util.*;

class Solution {

	public int solution(String t, String p) {
		int window = p.length();
		long target = Long.parseLong(p);
		return dfsIndex(0, t, window, target);
	}

	int dfsIndex(int i, String t, int window, long target) {

		if (i + window > t.length()) {
			return 0;
		}

		String sub = t.substring(i, i + window);
		long subNum = Long.parseLong(sub);
		int add = (subNum <= target) ? 1 : 0;

		return add + dfsIndex(i + 1, t, window, target);
	}
}