class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(0, nums.length - 1, nums);
        if (pivot == 0) {
            return binarySearch(0, nums.length - 1, nums, target);
        }
        if (target >= nums[0] && target <= nums[pivot - 1]) {
            return binarySearch(0, pivot - 1, nums, target);
        } else {
            return binarySearch(pivot, nums.length - 1, nums, target);
        }
    }

    public int findPivot(int start, int end, int[] nums) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public int binarySearch(int start, int end, int[] nums, int target) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return binarySearch(mid + 1, end, nums, target);
        } else {
            return binarySearch(start, mid - 1, nums, target);
        }

    }
}
