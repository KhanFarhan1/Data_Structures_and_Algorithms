class Solution {
    public int maxArea(int[] heights) {
        int MaxArea = Integer.MIN_VALUE;
        int area;
        int left =0;
        int right = heights.length-1;
        while(left<right){
            area = (right-left) * Math.min(heights[left] , heights[right]);
            MaxArea = Math.max(MaxArea , area);
            if(heights[left] > heights[right] ){
                right--;
            }else{
                left++;
            }
        }
        return MaxArea;
    }
}
