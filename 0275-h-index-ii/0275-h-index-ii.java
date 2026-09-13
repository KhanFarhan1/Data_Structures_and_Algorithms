class Solution {
    public boolean calculate(int[] citations , int ans){
        int count = 0;
        for(int i = 0;i<citations.length;i++){
            if(citations[i] >= ans){
                count++;
            }
            if(count == ans){
                return true;
            }
        }
        return false;
    }
    public int hIndex(int[] citations) {
        int si = 1;
        int ei = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0;i<citations.length;i++){
            ei = Math.max(ei , citations[i]);
        }
        while(si<=ei){
            int mid = si + (ei-si)/2;
            if(calculate(citations , mid)){
                ans = Math.max(ans , mid);
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        return ans;
    }
}