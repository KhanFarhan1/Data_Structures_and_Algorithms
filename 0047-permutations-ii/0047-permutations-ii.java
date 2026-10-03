class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer , Integer> freq = new HashMap<>();
        for(int i = 0 ;i<nums.length ; i++){
            freq.put(nums[i] , freq.getOrDefault(nums[i],0)+1);
        }
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        return wrap(nums , freq , sub , ans );
    }
    public List<List<Integer>> wrap( int[] nums,HashMap<Integer , Integer> freq , List<Integer> sub , List<List<Integer>> ans ){
        if(nums.length == sub.size()){
            ans.add(new ArrayList<>(sub));
            return ans;
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() >0){
                sub.add(entry.getKey());
                // if(entry.getValue() == 1){
                //     freq.remove(entry.getKey());
                // }else{
                //     freq.put(entry.getKey() , entry.getValue()-1);
                // }
                freq.put(entry.getKey() , entry.getValue()-1);
                wrap(nums,freq , sub , ans );
                sub.remove(sub.size()-1);
                freq.put(entry.getKey() , entry.getValue()+1);
            }
        }
        return ans;
    }
}