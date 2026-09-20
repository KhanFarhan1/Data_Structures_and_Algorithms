class Solution {
    class Pair{
        int first;
        Character second;
        Pair(int f , char s){
            this.first = f;
            this.second = s;
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first != b.first){
                return b.first-a.first;
                }
                return b.second.compareTo(a.second);
            }
        );
        HashMap<Character , Integer> freq = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character , Integer> entry : freq.entrySet()){
            pq.add(new Pair(entry.getValue() , entry.getKey()));
        }
        char pervious = 'x';
        int seat = 0;
        while(!pq.isEmpty()){
            if(seat == 0 || pervious != pq.peek().second){
                seat++;
                sb.append(pq.peek().second);
                pervious = pq.peek().second;
                int var = pq.peek().first -1;
                char str = pq.peek().second;
                pq.poll();
                if(var > 0){
                pq.add(new Pair(var , str));
                }
            }else{
                int var1 = pq.peek().first;
                char str1 = pq.peek().second;
                pq.poll();
                if(pq.isEmpty()){
                    return "";
                }
                int var2 = pq.peek().first;
                char str2 = pq.peek().second;
                pq.poll();
                sb.append(str2);
                var2 = var2-1;
                if(var2 >0){
                    pq.add(new Pair(var2 , str2));
                } 

                pq.add(new Pair(var1 , str1));
                pervious = str2;
                seat++;
            }
        }
        return sb.toString();
    }
}