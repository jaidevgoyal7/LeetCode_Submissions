class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        Map<Integer, Integer> hashTableCount = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            hashTable.put(num, hashTable.getOrDefault(num, 0) + 1);
            if (hashTable.get(num) > count) {
                count = hashTable.get(num);
                hashTableCount.clear();
                hashTableCount.put(num, count);
            } else if (hashTable.get(num) == count) {
                hashTableCount.put(num, count);
            }
        }
        Map<Integer, Integer> startIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int start = 0, end = nums.length - 1, index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (hashTableCount.containsKey(nums[i])) {
                if (!startIndex.containsKey(nums[i])) {
                    startIndex.put(nums[i], i);
                }
                lastIndex.put(nums[i], i);
            }
        }

        int minLength = nums.length;
        for (int num : hashTableCount.keySet()) {
            int length = lastIndex.get(num) - startIndex.get(num) + 1;
            minLength = Math.min(minLength, length);
        }

        return minLength;

    }
}