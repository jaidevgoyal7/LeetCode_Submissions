class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0, left = 0, zeroUsed = 0, n = nums.length, res = 0;

        while(right < n){
            if(nums[right] == 0){
                zeroUsed++;
            }

            while(zeroUsed > k){
                if(nums[left] == 0){
                    zeroUsed--;
                }
                left++;
            }

            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
}