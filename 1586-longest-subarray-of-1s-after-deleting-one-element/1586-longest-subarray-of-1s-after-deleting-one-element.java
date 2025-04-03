class Solution {
    public int longestSubarray(int[] nums) {
        int start = -1, end = 0, cntofZero = 0, prevZeroIdx = 0;
		int maxCntOfOne = 0;
		while (end < nums.length) {
			if (nums[end] == 0) {
				cntofZero++;
			}
			if (cntofZero > 1) {
				start = prevZeroIdx;
				cntofZero = 1;
			}
			maxCntOfOne = maxCntOfOne < end - start - cntofZero ? end - start - cntofZero : maxCntOfOne;
			prevZeroIdx = nums[end] == 0 ? end : prevZeroIdx;
			end++;
		}
		return cntofZero == 0 ? maxCntOfOne - 1 : maxCntOfOne;
    }
}