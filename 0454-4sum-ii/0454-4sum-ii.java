class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Long, Integer> sumFr = new HashMap<>();
        int res = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                long sum = nums1[i] + nums2[j];
                sumFr.put(sum, sumFr.getOrDefault(sum, 0) + 1);
            }
        }
        for(int k = 0; k < nums3.length; k++){
            for(int l = 0; l < nums4.length; l++){
                long sum = -(nums3[k] + nums4[l]);
                if(sumFr.containsKey(sum)){
                    res += sumFr.get(sum);
                }
            }
        }
        return res;
    }
}