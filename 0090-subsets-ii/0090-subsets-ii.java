class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        return wrap(nums , sub , ans , 0);
    }
    public List<List<Integer>> wrap(int[] nums , List<Integer> sub , List<List<Integer>> ans ,int index){
        if(index == nums.length){
            ans.add(new ArrayList<>(sub));
            return ans;
        }
        sub.add(nums[index]);
        wrap(nums , sub , ans , index+1);
        sub.remove(sub.size()-1);
        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index= index+1;
        }
        wrap(nums , sub , ans , index+1);
        return ans;
    }
}