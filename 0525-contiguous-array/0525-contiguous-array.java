

// Just do take count of zero and one make a loop the array check num[i] is one or zero and update thenafter if diff is zero that means no. of 1 and o is equal so take maximum and if diff is not zero so check whether the diff is come in hashmap or not 
// NOTE IN HASHMAP WE STORE DIFF AS KEY AND (i) OF IT AS VALUE
// case 1 : there is not data in hashmap is add it that yet
// case 2: if yes get the index and check max of ans and i-index

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
            /*Always use containsKey() to check if a key exists 
            in the HashMap; never use getOrDefault(diff,0) for existence
            checks because the stored value can be 0 (e.g., index 0). */
            freq.put(diff,i);
        }else{
            int v1 = freq.get(diff);
            ans = Math.max(ans,i-v1);
        }
       }
       return ans;
    }
}