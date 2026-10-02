class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        return wrap(nums , sub ,ans , index);
    }
    public List<List<Integer>> wrap(int[] nums , List<Integer> sub , List<List<Integer>> ans , int index){
        if(index == nums.length){
            ans.add(new ArrayList<>(sub));
            return ans;
        }
        sub.add(nums[index]);
        wrap(nums,sub , ans , index+1);
        sub.remove(sub.size()-1);
        wrap(nums , sub , ans ,index+1);
        return ans;
    }
}