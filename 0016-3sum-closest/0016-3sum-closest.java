class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int i = 0, n = nums.length;
        Arrays.sort(nums);
        int closet = nums[i] + nums[i+1] + nums[i+2];
        for(i = 0; i < n-2; i++){
            int left = i+1, right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < Math.abs(target - closet)){
                    closet = sum;
                }
                if(sum < target){
                    left++;
                }else if(sum > target){
                    right--;
                }else{
                    return target;
                }
            }
        }
        return closet;
    }
}