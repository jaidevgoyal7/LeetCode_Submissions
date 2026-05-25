class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxBitwiseOR = 0;

        for(int num : nums){
            maxBitwiseOR |= num; 
        }

        return backport(0, maxBitwiseOR, nums, new ArrayList<>());
    }

    public int backport(int i, int maxBitwiseOR, int[] nums, List<Integer> current){
        if(i == nums.length){
            int or = 0;
            for(int j = 0; j < current.size(); j++){
                or |= current.get(j); 
            }
            if(or == maxBitwiseOR){
                return 1;
            }else{
                return 0;
            }
        }

        current.add(nums[i]);
        int pick = backport(i+1, maxBitwiseOR, nums, current);
        current.remove(current.size()-1);
        int notpick = backport(i+1, maxBitwiseOR, nums, current);

        return pick + notpick;
    }
}