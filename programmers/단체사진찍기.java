import java.util.*;

class Solution {
	private static final char[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	private int[] pos = new int[26];
	private boolean[] used = new boolean[26];
	private List<Constraint> constraints;
	private int count;

	static class Constraint {
		char a, b, op;
		int dist;

		Constraint(String s) {
			a = s.charAt(0);
			b = s.charAt(2);
			op = s.charAt(3);
			dist = s.charAt(4) - '0';
		}
	}

	public int solution(int n, String[] data) {
		constraints = new ArrayList<>();
		for (String d : data)
			constraints.add(new Constraint(d));
		Arrays.fill(pos, -1);
		Arrays.fill(used, false);
		count = 0;
		backtrack(new char[8], 0);
		return count;
	}

	private void backtrack(char[] line, int idx) {
		if (idx == 8) {
			if (valid(line))
				count++;
			return;
		}
		for (char f : FRIENDS) {
			int fi = f - 'A';
			if (used[fi])
				continue;
			used[fi] = true;
			pos[fi] = idx;
			line[idx] = f;
			if (partialValid())
				backtrack(line, idx + 1);
			used[fi] = false;
			pos[fi] = -1;
		}
	}

	private boolean valid(char[] line) {
		for (Constraint c : constraints) {
			int pa = pos[c.a - 'A'];
			int pb = pos[c.b - 'A'];
			int gap = Math.abs(pa - pb) - 1;
			if (c.op == '=' && gap != c.dist)
				return false;
			if (c.op == '<' && gap >= c.dist)
				return false;
			if (c.op == '>' && gap <= c.dist)
				return false;
		}
		return true;
	}

	private boolean partialValid() {
		for (Constraint c : constraints) {
			int ia = pos[c.a - 'A'];
			int ib = pos[c.b - 'A'];
			if (ia != -1 && ib != -1) {
				int gap = Math.abs(ia - ib) - 1;
				if (c.op == '=' && gap != c.dist)
					return false;
				if (c.op == '<' && gap >= c.dist)
					return false;
				if (c.op == '>' && gap <= c.dist)
					return false;
			} else {
				int minPos = Math.min(ia == -1 ? 8 : ia, ib == -1 ? 8 : ib);
				int maxPos = Math.max(ia == -1 ? -1 : ia, ib == -1 ? -1 : ib);
				int placed = Math.max(ia, ib);
				int remainingSlotsLeft = placed == -1 ? 0 : placed;
				int remainingSlotsRight = 8 - (placed == -1 ? 0 : (placed + 1));
				if (ia != -1 && ib == -1) {
					if (c.op == '>' && remainingSlotsLeft + remainingSlotsRight - 1 <= c.dist)
						return false;
				} else if (ia == -1 && ib != -1) {
					if (c.op == '>' && remainingSlotsLeft + remainingSlotsRight - 1 <= c.dist)
						return false;
				}
			}
		}
		return true;
	}
}
