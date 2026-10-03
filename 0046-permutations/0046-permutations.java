class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        return wrap(nums,sub,ans,0);
    }
    public List<List<Integer>> wrap(int[] nums , List<Integer> sub , List<List<Integer>> ans  , int index){
        if(nums.length == sub.size()){
            ans.add(new ArrayList<>(sub));
            return ans;
        }
        for(int i = 0;i<nums.length ; i++){
            if(!sub.contains(nums[i])){
                sub.add(nums[i]);
                wrap(nums , sub , ans , i+1);
                sub.remove(sub.size()-1);
            }
        }
        return ans;
    }
}