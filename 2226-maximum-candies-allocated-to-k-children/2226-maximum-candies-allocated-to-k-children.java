// class Solution {
//     public boolean ispossible_4_kids(int[] candies , long k , int candy){
//         for(int i = 0;i<candies.length;i++){
//             int var1 = candies[i] / candy;
//             k = k - var1;
//             if(k <= 0){
//                 return true;
//             }
//         }
//         return false;
//     }
//     public int maximumCandies(int[] candies, long k) {
//         long total_candies = 0;
//         for(int i = 0;i<candies.length;i++){
//             total_candies += candies[i]; 
//         }
//         if(total_candies < k){
//             return 0;
//         }
//         int si = 1;
//         int ei =total_candies/k;
//         int ans = 0;
//         while(si <= ei){
//             int mid = si + (ei - si)/2;
//             boolean possible = ispossible_4_kids(candies,k,mid);
//             if(possible == true){
//                 ans = mid;
//                 si = mid+1;
//             }else{
//                 ei = mid-1;
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public boolean ispossible_4_kids(int[] candies , long k , long candy){
        for(int i = 0;i<candies.length;i++){
            long var1 = candies[i] / candy;
            k = k - var1;
            if(k <= 0){
                return true;
            }
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        long total_candies = 0;
        for(int i = 0;i<candies.length;i++){
            total_candies += candies[i]; 
        }
        if(total_candies < k){
            return 0;
        }
        long si = 1;
        long ei =total_candies/k;
        long ans = 0;
        while(si <= ei){
            long mid = si + (ei - si)/2;
            boolean possible = ispossible_4_kids(candies,k,mid);
            if(possible == true){
                ans = mid;
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        return (int)ans;
    }
}