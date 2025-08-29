class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, res = nums[0], maxCurr = nums[0];

        for(int i = 1; i < n; i++){
            maxCurr = Math.max(maxCurr + nums[i], nums[i]);
            res = Math.max(res, maxCurr);
        }

        return res;

    }
}