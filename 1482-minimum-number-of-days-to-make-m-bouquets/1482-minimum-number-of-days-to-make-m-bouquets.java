class Solution {
    public boolean calculate_day(int[] bloomDay , int m ,int k , int days){
        int count = 0;
        int bouquest = 0;
        for(int i = 0;i<bloomDay.length;i++){
            if(bloomDay[i] <= days){
                count++;
            }else{
                count=0;
            }
            if(count == k){
                bouquest++;
                count = 0;
            }
            if(bouquest == m){
                return true;
            }
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int ans = Integer.MAX_VALUE;
        long product = (long)m*k;
        if(product > n){
            return -1;
        }
        if(m == 0 || k == 0){
            return 0;
        }
        int si = Integer.MAX_VALUE;
        int ei = Integer.MIN_VALUE;
        for(int i = 0;i<bloomDay.length;i++){
            si = Math.min(si , bloomDay[i]);
            ei = Math.max(ei , bloomDay[i]);
        }
        //Mean all flower will grow in single day
        if(si == ei){
            return ei;
        }
        //else
        while(si <= ei){
            int mid = si + (ei - si)/2;
            boolean valid_day = calculate_day(bloomDay , m , k, mid);
            if(valid_day == false){
                //we have to increase mid
                si = mid+1;
            }else{
                //else store it and serach for even-lesser
                ans = Math.min(ans , mid);
                ei = mid-1;
            }
        }
        return ans;
    }
}