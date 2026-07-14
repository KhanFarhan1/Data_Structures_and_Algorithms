class Solution {
    public int minfun(int [] nums , int k){
        int high =0;
        int low = 0;
        int count = 0 ; 
        HashMap<Integer,Integer> freq = new HashMap<>();
        while(high<nums.length){
            freq.put(nums[high], freq.getOrDefault(nums[high],0)+1);
            while(freq.size()>k){
                freq.put(nums[low],freq.get(nums[low])-1);
                if(freq.get(nums[low])==0){
                    freq.remove(nums[low]);
                }
                low++;
            }
            count +=high-low+1;
        high++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return minfun(nums,k)-minfun(nums,k-1);
    }
}