class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), result);
        return result;        
    }

    public void backtrack(int index, int[] nums, List<Integer> current,List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backtrack(index+1, nums, current, result);
        current.remove(current.size() - 1);
        while(index + 1 < nums.length && nums[index] == nums[index+1]){
            index += 1;
        }
        backtrack(index+1, nums, current, result);
    }
}