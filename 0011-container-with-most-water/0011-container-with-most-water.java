class Solution {
    public int maxArea(int[] height) {
        int currWater;
        int maxWater = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            currWater = Math.min(height[left] , height[right]) * (right - left);
            maxWater = Math.max(currWater , maxWater);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}