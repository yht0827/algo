import java.util.*;

class Solution {
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		int extIdx = toIndex(ext);
		int sortIdx = toIndex(sort_by);

		List<int[]> filtered = new ArrayList<>();
		for (int[] row : data) {
			if (row[extIdx] < val_ext) {
				filtered.add(row);
			}
		}

		filtered.sort((a, b) -> Integer.compare(a[sortIdx], b[sortIdx]));

		return filtered.toArray(new int[filtered.size()][]);
	}

	private int toIndex(String key) {
		switch (key) {
			case "code":
				return 0;
			case "date":
				return 1;
			case "maximum":
				return 2;
			case "remain":
				return 3;
			default:
				return 999;
		}
	}
}
