class Solution {
    public int searchInsert(int[] nums, int target) {
        int small = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < target){
                small = i;
            }else if (nums[i] == target){
                return i;
            }
        }
        if(small > -1){
            return small+1;
        }else{
            return 0;
        }
        
    }
}
