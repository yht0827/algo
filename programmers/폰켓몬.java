import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public int solution(int[] nums) {
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

		int n = nums.length / 2;

		return Math.min(set.size(), n);
	}
}