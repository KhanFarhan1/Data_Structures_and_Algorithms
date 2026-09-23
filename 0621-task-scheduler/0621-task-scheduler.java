class Solution {
    class Pair{
        int count;
        Character ch;
        Pair(int f , Character c){
            this.count = f;
            this.ch = c;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        if(n == 0){
            return tasks.length;
        }
        int ans = 0;
        HashMap<Character,Integer> freq = new HashMap<>();
        HashMap<Character , Integer> free = new HashMap<>();
        for(int i = 0;i<tasks.length;i++){
            char c = tasks[i];
            freq.put(c , freq.getOrDefault(c,0)+1);
            free.put(c, 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                return b.count - a.count;
            }
        );
        for(Map.Entry<Character , Integer> entry : freq.entrySet()){
            char c = entry.getKey();
            int v = entry.getValue();
            pq.add(new Pair(v , c));
        }
        while(!pq.isEmpty()){
            HashMap<Character , Integer> remain = new HashMap<>();
            while(!pq.isEmpty()){
                char c = pq.peek().ch;
                int f = pq.peek().count;
                pq.poll(); 
                if(ans == 0 || free.get(c)<=ans){
                    f = f-1;
                    if(f > 0){
                        pq.add(new Pair(f , c));
                        free.put(c , ans+n+1);
                    }
                    break;
                }else{
                    remain.put(c,f);
                }
            }
            for(Map.Entry<Character , Integer> entry : remain.entrySet()){
                pq.add(new Pair(entry.getValue(),entry.getKey()));
            }
            ans++;
        }
        return ans;
    }
}