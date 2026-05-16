class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length, i = 1;
        int tmp = nums[0];
        while(i<n){
            tmp = tmp ^ nums[i];
            i++;
        }
        return tmp;
    }
}