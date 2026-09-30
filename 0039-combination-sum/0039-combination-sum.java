class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        return wrap(sub , res , 0 , candidates , target , 0);
    }
    public List<List<Integer>> wrap( List<Integer> sub ,List<List<Integer>> res,int index ,int[] candidates, int target , int sum){
        if(sum == target){
            res.add(new ArrayList<>(sub));
            return res;
        }
        if(candidates.length == index){
            return res;
        }
        if(sum + candidates[index] <= target){
            sum = sum + candidates[index];
            sub.add(candidates[index]);
            wrap(sub , res, index , candidates , target , sum);
            sum = sum - candidates[index];
            sub.remove(sub.size()-1);
        }
            wrap(sub , res , index+1 ,candidates , target , sum);
        return res;
    }
}