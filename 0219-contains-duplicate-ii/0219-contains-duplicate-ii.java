class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<=Math.min(i+k, nums.length-1); j++) {
                if (nums[i]==nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}