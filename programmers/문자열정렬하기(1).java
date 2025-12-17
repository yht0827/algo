import java.util.*;

class Solution {
	public int[] solution(String my_string) {

		List<Integer> answer = new ArrayList<>();

		for (char ch : my_string.toCharArray()) {
			if (Character.isDigit(ch)) {
				answer.add(ch - '0');
			}
		}

		return answer.stream().sorted().mapToInt(i -> i).toArray();
	}
}