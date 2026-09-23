class Solution {
    class Pair{
        int capital;
        int profit;
        Pair(int c , int p){
            this.capital = c;
            this.profit = p;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> MinHeap = new PriorityQueue<>(
            (a,b)->{
                return a.capital - b.capital;
            }
        );
        PriorityQueue<Pair> MaxHeap = new PriorityQueue<>(
            (a,b)->{
                return b.profit-a.profit;
            }
        );
        for(int i = 0;i<profits.length;i++){
            MinHeap.add(new Pair(capital[i] , profits[i]));
        }
        while(k>0){
            while(!MinHeap.isEmpty() && MinHeap.peek().capital<=w){
                MaxHeap.add(new Pair(MinHeap.peek().capital , MinHeap.peek().profit));
                MinHeap.poll();
            }
            if(MaxHeap.isEmpty()){
                break;
            }
            w = w + MaxHeap.poll().profit;
            k--;
        }
        return w;
    }
}