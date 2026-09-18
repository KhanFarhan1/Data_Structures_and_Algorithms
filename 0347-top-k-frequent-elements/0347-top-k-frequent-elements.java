class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first , int second){
            this.first = first;
            this.second = second;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer ,Integer> freq = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            freq.put(nums[i] , freq.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue <Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first != b.first){
                    return a.first-b.first;
                }
                return a.second-b.second;
            }
        );
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            pq.add(new Pair(value , key));
            if(pq.size() >k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i =0;i<k;i++){
            ans[i] = pq.poll().second;
        }
        return ans;
    }
}