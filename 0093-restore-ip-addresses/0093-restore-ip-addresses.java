class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if( s.length() >=4 ){
            backtrack(0, new ArrayList<>(), s, result);
        }else{
            return new ArrayList<>();
        }
        return result;
    }

    public void backtrack(int i, List<String> parts,String s, List<String> result){
        if(parts.size() == 4 && s.length() == i ){
            result.add(String.join(".", parts));
        }
        for(int j = 1; j <= 3; j++){
            if(i + j > s.length()){
                break;
            }
            String sub = s.substring(i, i + j);
            int d = Integer.parseInt(sub);
            if(d > 255 || d < 0){
                return;
            }
            if(sub.length() > 1 && sub.charAt(0) == '0'){
                return;
            }

            parts.add(sub);

            backtrack(i+j, parts, s, result);

            parts.remove(parts.size() - 1);

        }
    }
}