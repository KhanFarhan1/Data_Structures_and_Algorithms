class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        st.push(n-1);
        ans[n-1] = 0;
        int count=0;
        for(int i = n-2;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
                count++;
            }
            if(st.isEmpty()){
                ans[i] = 0;
            }else{
                ans[i] = st.peek()-i;
                count = 0;
            }
            st.push(i);
        }
        return ans;
    }
}
