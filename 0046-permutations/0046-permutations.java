class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        return wrap(num , sub , ans ,0);
    }
    public List<List<Integer>> wrap(int[] num , List<Integer> sub , List<List<Integer>> ans ,int index){
        if(sub.size() == num.length){
            ans.add(new ArrayList<>(sub));
            return ans;
        }
            for(int i = 0;i<num.length;i++){
                if(!sub.contains(num[i])){
                    sub.add(num[i]);
                    wrap(num , sub , ans , i+1 );
                    sub.remove(sub.size()-1);
                }
            }
        return ans;
    }
}