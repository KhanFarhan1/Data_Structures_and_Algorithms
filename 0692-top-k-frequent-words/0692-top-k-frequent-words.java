class Solution {
    class Pair{
        int first;
        String second;

        Pair(int first , String second){
            this.first = first;
            this.second = second;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        //HashMap for counting how much is quatity
        HashMap<String , Integer> freq = new HashMap<>();
        for(int i = 0;i<words.length;i++){
            freq.put(words[i] , freq.getOrDefault(words[i] , 0)+1);
        }
        // max-heap for int, min-heap for String
        PriorityQueue <Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first != b.first){
                    return b.first-a.first;
                }
                return a.second.compareTo(b.second);
            }
        );
        //add hashmap element to heap
       for(Map.Entry<String,Integer> entry : freq.entrySet()){
        String key = entry.getKey();
        int value = entry.getValue();
        pq.add(new Pair(value , key));
       }
       //creating k size list for string to return it
       ArrayList<String> ans = new ArrayList<>();
       while(k != 0){
        ans.add(pq.poll().second);
        k--;
       }
       return ans;
    }
}