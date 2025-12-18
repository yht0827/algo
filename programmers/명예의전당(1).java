import java.util.*;

class Solution {
	public int[] solution(int k, int[] score) {
		int length = score.length;
		int[] answer = new int[length];
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < length; i++) {
			pq.offer(score[i]);

			if (pq.size() > k)
				pq.poll();

			answer[i] = pq.peek();
		}
		return answer;
	}
}