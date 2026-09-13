class Solution {
    public int mySqrt(int x) {
        int si = 1;
        int ei = x;
        int ans = 0;
        while(si <= ei){
            int mid = si +( ei - si )/2;
            if(Math.pow(mid , 2)> x){
                ei = mid-1;
            }else{
                ans = Math.max(ans, mid);
                si = mid+1;
            }
        }
        return ans;
    }
}