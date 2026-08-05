/*
why we have written this :
            if(rem < 0){
                rem = rem + k;
            } 
    is Because 4 mod 5 is 4 and -4 mod 5 is not -4 it is 1 since we do is -4+k i.e. -4+5 = 1
    in program we write is 1. calculate mod wheather is negative or postive and then if negative JUST ADD  K 
 */

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer , Integer> freq = new HashMap<>();
        freq.put(0,1);
        int sum = 0;
        int res= 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0){
                rem = rem + k;
            }
            res = res + freq.getOrDefault(rem , 0);
            freq.put(rem,freq.getOrDefault(rem , 0)+1);
        }
        return res;
    }
}