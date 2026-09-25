class Solution {
    class Pair{
        int soldier;
        int idx;
        Pair(int s , int i){
            this.soldier = s;
            this.idx = i;
        }
    }   
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.soldier != b.soldier){
                    return a.soldier-b.soldier;
                }
                return a.idx-b.idx;
            }
        );
        for(int i = 0;i<mat.length ; i++){
            int j;
            for(j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    pq.add(new Pair(j , i));
                    break;
                }
            }
            if(j == mat[0].length){
                pq.add(new Pair(j , i));
            }
        }
        int [] ans = new int[k];
        int i =0;
        while( k > 0 && !pq.isEmpty()){
            ans[i] = pq.poll().idx;
            i++;
            k--;
        }
        return ans;
    }
}