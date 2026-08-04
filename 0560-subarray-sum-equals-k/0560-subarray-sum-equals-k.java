class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        freq.put(0,1);
        int prefix = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            prefix = prefix+nums[i];
            int diff = prefix - k;
            count = count + freq.getOrDefault(diff , 0);
            freq.put(prefix , freq.getOrDefault(prefix , 0)+1);
        }
        return count;
    }
}