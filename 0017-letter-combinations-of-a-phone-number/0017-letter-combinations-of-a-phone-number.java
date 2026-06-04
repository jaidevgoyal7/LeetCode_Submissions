class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Integer, List<Character>> hm = new HashMap<>();
        
        char lastChar = 'a';
        for(int i = 2; i < 10; i++){
            List<Character> letters = new ArrayList<>();
            if(i != 9 && i != 7){
                letters.add(lastChar);
                letters.add((char)(lastChar + 1));
                letters.add((char)(lastChar + 2));
                lastChar = (char)(lastChar + 3);
            }else if(i == 7){
                letters.add(lastChar);
                letters.add((char)(lastChar + 1));
                letters.add((char)(lastChar + 2));
                letters.add((char)(lastChar + 3));
                lastChar = (char)(lastChar + 4);
            }else{
                letters.add(lastChar);
                letters.add((char)(lastChar + 1));
                letters.add((char)(lastChar + 2));
                letters.add((char)(lastChar + 3));
            }
            hm.put(i, letters);
        }
        backtracking(digits, 0, new StringBuilder(), result, hm);
        return result;
    }

    public void backtracking(String digits, int index, StringBuilder current, List<String> result, Map<Integer, List<Character>> hm){
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';

        for(char ch : hm.get(digit)){
            current.append(ch);
            backtracking(digits, index+1, current, result, hm);
            current.deleteCharAt(current.length() - 1);
        }
    }
}