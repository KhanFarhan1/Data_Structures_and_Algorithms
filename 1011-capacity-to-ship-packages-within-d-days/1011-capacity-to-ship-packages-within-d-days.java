class Solution {
    public boolean calculate_day(int[] weights , int days , int predicted_weight){
        int var1 = 0;
        for(int i = 0;i<weights.length;i++){
            var1 += weights[i];
            if(var1 <= predicted_weight){
                continue;
            }
            var1 = var1 - weights[i];
            i--;
            days--;
            var1 = 0;
            if(days == 0){
                return false;
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int si = 1;
        int ei = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<weights.length;i++){
            ei = ei + weights[i];
        }
        while(si <= ei){
            int mid = si + (ei - si)/2;
            boolean toogle = calculate_day(weights , days , mid);
            if(toogle == true){
                ans = Math.min(ans , mid);
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
        return ans;
    }
}