class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<> ();
        int open = 0, close = 0;
        backtrack(open, close, "", n, result);
        return result;
    }

    public void backtrack(int open, int close, String current, int n, List<String> result){
        if(current.length() == 2*n){
            result.add(current);
            return;
        }
        if(open < n){
            backtrack(open+1, close, current + "(", n, result);
        }
        if(close < open){
            backtrack(open, close+1, current + ")", n, result);
        }
    }
}