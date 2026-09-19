class Solution {
    class Pair{
        int first;
        int second;
        Pair(int f , int s){
            this.first = f;
            this.second = s;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(Math.abs(a.first-x) != Math.abs(b.first-x)){
                    return Math.abs(b.first-x)-Math.abs(a.first-x);
                }
                return b.first-a.first;
            }
        );
        for(int i = 0;i<k;i++){
            pq.add(new Pair(arr[i] , i));
        }
        for(int i = k;i<arr.length;i++){
            if(Math.abs(pq.peek().first - x) > Math.abs(arr[i] -x ) ){
                pq.poll();
                pq.add(new Pair(arr[i] , i));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(pq.size()!=0){
            ans.add(pq.poll().first);
        }
        Collections.sort(ans);
        return ans;
    }
}