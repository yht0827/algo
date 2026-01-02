class Solution {
	public long solution(int a, int b) {
		long start = Math.min(a, b);
		long end = Math.max(a, b);
		long n = end - start + 1;
		return n * (start + end) / 2;
	}
}
