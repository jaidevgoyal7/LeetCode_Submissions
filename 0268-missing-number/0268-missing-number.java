class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, tmp = 0;
        for(int i = 0; i<n; i++){
            tmp = tmp ^ (i ^ nums[i]);
        }
        tmp = tmp ^ n;
        return tmp;
    }
}