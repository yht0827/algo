import java.util.*;

class Solution {
	public int[] solution(String s) {

		List<Integer> answer = new ArrayList<>();
		Map<Character, Integer> alpha = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (alpha.containsKey(ch)) {
				answer.add(i - alpha.get(ch));
				alpha.put(ch, i);
			} else {
				alpha.put(ch, i);
				answer.add(-1);
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
}