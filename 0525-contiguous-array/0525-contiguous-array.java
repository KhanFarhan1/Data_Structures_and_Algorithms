//Store the first occurrence of each diff = zero_count - one_count in the HashMap. When the same diff appears again, the subarray between them has an equal number of 0s and 1s, so update the maximum length.
// Never use getOrDefault() to check if a key exists. Use containsKey() because the first occurrence may be at index 0, and overwriting it loses the longest possible subarray.
//you can dry run on [0,0,1]

// class Solution {
//     public int findMaxLength(int[] nums) {
//         int ans = 0;
//         for(int i = 0;i<nums.length;i++){
//         int one_count = 0;
//         int zero_count = 0;
//             for(int j = i;j<nums.length;j++){
//                 if(nums[j]==0){
//                     zero_count++;
//                 }else{
//                     one_count++;
//                 }
//                 if(one_count==zero_count){
//                     ans = Math.max(ans , j-i+1);
//                 }
//             }
//         }
//         return ans;
//     }
// }
class Solution{
    public int findMaxLength(int[] nums) {
       HashMap <Integer , Integer> freq = new HashMap<>();
       int zero_count  = 0;
       int one_count = 0;
       int ans = 0;
       for(int i = 0;i<nums.length;i++){
        if(nums[i] == 0){
            zero_count++;
        }else{
            one_count++;
        }
        int diff = zero_count-one_count;
        if(diff == 0){
            ans = Math.max(ans , i+1);
            continue;
        }
        if(!freq.containsKey(diff)){
            freq.put(diff,i);
        }else{
            int v1 = freq.get(diff);
            ans = Math.max(ans,i-v1);
        }
       }
       return ans;
    }
}