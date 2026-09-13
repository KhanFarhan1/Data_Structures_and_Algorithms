class Solution {
    public boolean calculate_day(int[] weights , int days , int predicted_weight){
        int var1 = 0;
        for(int i = 0;i<weights.length;i++){
            if(var1 + weights[i] <= predicted_weight){
                var1 += weights[i];
                continue;
            }
            days--;
            var1 = weights[i];
            if(var1 > predicted_weight){   
            return false;
            }
            if(days == 0){
                return false;
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int si = Integer.MIN_VALUE;
        int ei = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<weights.length;i++){
            si =Math.max(si , weights[i]);
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