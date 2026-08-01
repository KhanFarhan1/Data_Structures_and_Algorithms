class Solution {
    public int maximumSum(int[] arr) {
        int nodelete = arr[0];
        int ans = arr[0];
        int onedelete = Integer.MIN_VALUE;
        for(int i = 1;i<arr.length;i++){
            int prev_nodelete = nodelete;
            int prev_onedelete = onedelete;
            nodelete = Math.max(prev_nodelete+arr[i] , arr[i]);
            int v2;
            if(prev_onedelete == Integer.MIN_VALUE){
                v2 = arr[i];
            }else{
                v2 = prev_onedelete+arr[i];
            }
            onedelete = Math.max(v2 , prev_nodelete);
            ans = Math.max(ans,Math.max(nodelete,onedelete));
        }
        return ans;
    }
}