class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], maxProd = nums[0], minProd = nums[0], n = nums.length;

        for(int i = 1; i < n; i++){
            int tmpMax = maxProd;
            maxProd = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
            minProd = Math.min(nums[i], Math.min(tmpMax * nums[i], minProd * nums[i]));
            res = Math.max(res, maxProd);
        }

        return res;
    }
}