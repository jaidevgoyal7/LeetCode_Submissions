class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int i = num.length - 1;
        List<Integer> list = new ArrayList<>();
        while(i >= 0 || k > 0){
            if(i >= 0){
                k += num[i];
            }
            list.add(k%10);
            k = k/10;
            i--;
        }
        Collections.reverse(list);
        return list;
    }
}