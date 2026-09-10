class Solution {
    public long calculate_time(int[] arr , int k){
        long hours = 0;
        for(int i = 0;i<arr.length;i++){
            hours = hours + arr[i]/k;
            if(arr[i]%k != 0){
               hours++; 
            }
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int si = 1;
        int ei = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<piles.length ; i++){
            ei = Math.max(ei , piles[i]);
        }
        while(si <= ei){
            int mid = si + (ei - si)/2;
            long time = calculate_time(piles , mid);
            if(time >h  ){
                //speed is too slow
                si = mid+1;
            }else{
                //spped work but try lesser than it
                ei = mid-1;
                ans = Math.min(ans , mid);
            }
        }
        return ans;
    }
}