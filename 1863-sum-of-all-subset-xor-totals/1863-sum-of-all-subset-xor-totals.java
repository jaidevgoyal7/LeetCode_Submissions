class Solution {
    public int subsetXORSum(int[] nums) {
        return backtrack(0, nums, new ArrayList<>());
    }

    public int backtrack(int i, int[] nums, List<Integer> current){
        if(i == nums.length){
            int xor = 0;
            for(int j = 0; j < current.size(); j++){
                xor = xor ^ current.get(j);
            }
            return xor;
        }
        current.add(nums[i]);
        int pick = backtrack(i+1, nums, current);
        current.remove(current.size()-1);
        int notpick = backtrack(i+1, nums, current);

        return pick + notpick;
    }
}