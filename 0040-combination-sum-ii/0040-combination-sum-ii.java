class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrackSum(0, new ArrayList<>(), candidates, target, result);

        return result;
    }

    public void backtrackSum(int index, List<Integer> current, int[] candidates, int target, List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target < 0 || index >= candidates.length){
            return;
        }
        current.add(candidates[index]);
        backtrackSum(index+1, current, candidates, target-candidates[index], result);

        current.remove(current.size() - 1);
        while(index + 1 < candidates.length && candidates[index] == candidates[index+1]){
            index += 1;
        }
        backtrackSum(index+1, current, candidates, target, result);
        
    }
}