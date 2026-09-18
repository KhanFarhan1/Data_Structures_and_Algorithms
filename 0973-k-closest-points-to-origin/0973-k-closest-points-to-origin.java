class Solution {
    class Pair{
        int first;
        int second;
        Pair(int f , int s){
            this.first = f;
            this.second = s;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue <Pair> pq = new PriorityQueue<>(
            (a,b)->{
                return b.first-a.first;
            }
        );
        HashMap<Integer , Integer> freq = new HashMap<>();
        for(int i =0 ;i<points.length;i++){
            //int dist = (int)Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            freq.put(i , dist);
        }
        for(Map.Entry<Integer , Integer> entry : freq.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            pq.add(new Pair(value , key));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        for(int i = 0;i<k;i++){
            int indx = pq.poll().second;
            ans[i][0] = points[indx][0];
            ans[i][1] = points[indx][1];
        }
        return ans;
    }
}