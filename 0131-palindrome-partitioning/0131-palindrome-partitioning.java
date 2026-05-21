class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<> ();
        
        backtrack(0, new ArrayList<> (), s, result);
        return result;
    }

    public void backtrack(int start, List<String> current, String s, List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int end = start; end < s.length(); end++){
            if(validPalindrome(start, end, s)){
                current.add(s.substring(start, end + 1));
                backtrack(end+1, current, s, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean validPalindrome(int left, int right, String s){
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}