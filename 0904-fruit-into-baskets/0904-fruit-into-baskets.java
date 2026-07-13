class Solution {
    public int totalFruit(int[] fruits) {
        int high = 0;
        int low =0;
        int ans = -1;
        int n = fruits.length;
        HashMap<Integer,Integer> freq=new HashMap<>();
        while(high<n){
            freq.put(fruits[high],freq.getOrDefault(fruits[high],0)+1);
            while(freq.size()>2){
                freq.put(fruits[low],freq.get(fruits[low])-1);
                if(freq.get(fruits[low])==0){
                    freq.remove(fruits[low]);
                }
                low++;
            }
            ans = Math.max(ans,high-low+1);
            high++;
        }
        return ans;
    }
}