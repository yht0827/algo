import java.util.*;

class Solution {
	public int solution(int[] schedules, int[][] timelogs, int startday) {
		int n = schedules.length;
		int answer = 0;

		int[] allowed = new int[n];
		for (int i = 0; i < n; i++) {
			allowed[i] = addMinutesHHMM(schedules[i], 10);
		}

		for (int i = 0; i < n; i++) {
			boolean allWeekdaysOnTime = true;
			for (int dayIdx = 0; dayIdx < 7; dayIdx++) {
				int weekday = ((startday - 1 + dayIdx) % 7) + 1;
				if (weekday == 6 || weekday == 7) {

					continue;
				}

				if (timelogs[i][dayIdx] > allowed[i]) {
					allWeekdaysOnTime = false;
					break;
				}
			}
			if (allWeekdaysOnTime) {
				answer++;
			}
		}

		return answer;
	}

	private int addMinutesHHMM(int hhmm, int addMin) {
		int hh = hhmm / 100;
		int mm = hhmm % 100;
		int totalMin = hh * 60 + mm + addMin;
		int newH = totalMin / 60;
		int newM = totalMin % 60;
		return newH * 100 + newM;
	}
}
