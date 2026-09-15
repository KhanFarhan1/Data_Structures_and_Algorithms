class Solution {
    public int calculate(int m , int n , int guess){
        int count = 0;
        int i = m;
        int j = 1;
        while(i > 0 && j<=n ){
            if(i*j <= guess){
                count = count + i;
                j++;
                continue;
            }
            i--;
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int si = 1;
        int ei = m * n;
        int ans = Integer.MAX_VALUE;
        while(si <= ei){
            int mid = si + (ei -si)/2;
            int guess = calculate(m , n , mid);
            if(guess < k){
                si = mid+1;
            }else{
                ans = Math.min(ans , mid);
                ei = mid-1;
            }
        }
        return ans;
    }
}