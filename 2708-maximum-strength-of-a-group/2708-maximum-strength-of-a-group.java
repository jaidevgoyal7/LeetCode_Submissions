class Solution {
    long result = Long.MIN_VALUE;

    public long maxStrength(int[] nums) {
        backtrack(0, nums, new ArrayList<>());

        return result;
    }

    public void backtrack(int i, int[] nums, List<Integer> current) {

        if (i == nums.length) {
            if (current.isEmpty()) {
                return;
            }
            long product = 1;
            for (int num : current) {
                product *= num;
            }
            result = Math.max(result, product);
            return;
        }

        current.add(nums[i]);
        backtrack(i + 1, nums, current);
        current.remove(current.size() - 1);
        backtrack(i + 1, nums, current);
    }
}