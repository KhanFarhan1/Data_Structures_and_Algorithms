class Solution {
    public int largestRectangleArea(int[] heights) {
       int ans = Integer.MIN_VALUE;
       int [] NSL = new int [heights.length];
       int [] NSR = new int [heights.length];
       Stack <Integer> st = new Stack<>();
       int n = heights.length;
       NSR[n-1]=n;
       st.push(n-1);
       //for nsr
       for(int i = n-2;i>=0;i--){
        while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
            st.pop();
        }
        if(st.isEmpty()){
            NSR[i]=n;
        }else{
            NSR[i]=st.peek();
        }
        st.push(i);
       }
       //for nsl
       st = new Stack<>();
       for(int i =0;i<n;i++){
        while(!st.isEmpty()&& heights[st.peek()]>=heights[i]){
            st.pop();
        }
        if(st.isEmpty()){
            NSL[i] = -1;
        }else{
            NSL[i] = st.peek();
        }
        st.push(i);
       }
       //calculation
       for(int i = 0;i<heights.length;i++){
        int curr = heights[i] * (NSR[i] - NSL[i] - 1);
        ans = Math.max(ans , curr);
       }
       return ans;
    }
}