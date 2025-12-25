import java.util.*;

class Solution {
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, String> map = new HashMap<>();
		Map<String, Integer> resultMap = new HashMap<>();

		for (int i = 0; i < enroll.length; i++) {
			map.put(enroll[i], referral[i]);
		}

		for (int i = 0; i < seller.length; i++) {
			String str = seller[i];
			int money = amount[i] * 100;

			while (!str.equals("-") && money > 0) {
				resultMap.put(str, resultMap.getOrDefault(str, 0) + money - (money / 10));
				str = map.get(str);
				money /= 10;
			}
		}

		int[] result = new int[enroll.length];

		for (int i = 0; i < enroll.length; i++) {
			result[i] = resultMap.getOrDefault(enroll[i], 0);
		}

		return result;
	}
}