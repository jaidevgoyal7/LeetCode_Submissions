class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = 0, n = nums.length, res = 0;

        while(right < n){

            while(right < n && nums[right] == nums[left]){
                right++;
            }

            if(right >= n){
                break;
            }

            if(nums[right] - nums[left] == 1){
                int leftCount = right - left;

                int rightCurr = right;
                while(right < n && nums[right] == nums[rightCurr]){
                    right++;
                }
                int rightCount = right - rightCurr;

                res = Math.max(res, rightCount + leftCount);

                left = rightCurr;
                right = rightCurr;
            }else{
                left = right;
            }


        }
        return res;
        
    }
}