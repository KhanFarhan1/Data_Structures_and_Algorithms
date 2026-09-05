class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            freq.put(nums[i] , freq.getOrDefault(nums[i],0)+1);
        }
        int ans = Integer.MIN_VALUE;
        for(int i:freq.keySet()){
            if(freq.getOrDefault(i-1,0)>0){
                continue;
            }else{
                int curr = i+1;
                int count=1;
                while(freq.getOrDefault(curr,0)>0){
                    curr++;
                    count++;
                }
                ans = Math.max(ans , count);
            }
        }
        return ans;
    }
}