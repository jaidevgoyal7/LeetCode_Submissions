class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int res = 0, current = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == max){
                current++;
                res = Math.max(current, res);
            }else{
                current = 0;
            }
        }
        return res;
    }
}