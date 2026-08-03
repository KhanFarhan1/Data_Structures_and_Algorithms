class Solution {
    public int minSwaps(int[] nums) {
        //COUNT ONE 
        int count_one = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==1){
                count_one++;
            }
        }
        //SLIDING WINDOW 
        int high = 0;
        int low = 0;
        int window_one = 0;
        int max_one = Integer.MIN_VALUE;
       while(high != 2*nums.length){
        if(nums[high%nums.length]== 1){
            window_one++;
        }
        if(high-low+1>count_one){
            if(nums[low%nums.length] == 1){
                window_one--;
            }
            low++;
        }
        max_one = Math.max(max_one,window_one);
        high++;
       }
       return count_one-max_one;
    }
}