class Solution {
    public int minfun(int a,int b){
        if(b == 0){
            return a;
        }
        return minfun(b,a%b);
    }
    public int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            smallest = Math.min(smallest,nums[i]);
            largest = Math.max(largest,nums[i]);
        }
        return minfun(smallest,largest);
    }
}