class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int firstIndex = firstBinarySearch(0, nums.length - 1, nums, target);

        if(firstIndex != -1){
            while(firstIndex < nums.length && nums[firstIndex] == target){
                result.add(firstIndex);
                firstIndex++;
            }
        }
        return result;
    }

    public int firstBinarySearch(int left, int right, int[] nums, int target){
        int firstIndex = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                firstIndex = mid;
                right = mid - 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return firstIndex;
    }

}