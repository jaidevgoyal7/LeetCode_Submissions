class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
    
        backtrackSum(0, new ArrayList<>(), candidates, target, result);
        return result;
    }

    public void backtrackSum(int index, List<Integer> currentList,int[] candidates, int target, List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(currentList));
            return;
        }

        if(target < 0 || index >= candidates.length){
            return;
        }

        currentList.add(candidates[index]);
        backtrackSum(index, currentList, candidates, target-candidates[index], result);

        currentList.remove(currentList.size() - 1);

        backtrackSum(index+1, currentList, candidates, target, result);
    }
}