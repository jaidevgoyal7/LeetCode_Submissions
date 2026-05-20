class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrackUnique(nums, new ArrayList<>(), visited, result);

        return result;
    }

    public void backtrackUnique(int[] nums, List<Integer> current, boolean[] visited, List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new ArrayList(current));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            
            visited[i] = true;
            current.add(nums[i]);
            backtrackUnique(nums, current, visited, result);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}