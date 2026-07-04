class Solution {
    public int maxArea(int[] height) {
        return twopointer(0, height.length - 1, height);
    }

    public int twopointer(int left, int right, int[] height){
        int area = 0;
        while(left < right && left < height.length && right < height.length){
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return area;
    }
}