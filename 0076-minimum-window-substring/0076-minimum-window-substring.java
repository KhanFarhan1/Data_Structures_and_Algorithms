class Solution {
    public String minWindow(String s, String t) {
       int m = s.length();
       int n = t.length();
       int high =0;
       int low =0;
       int startIdx = -1;
       int len =Integer.MAX_VALUE;
       int count = 0;
       HashMap<Character,Integer> freq = new HashMap<>();
       for(int i = 0;i<n;i++){
        char c = t.charAt(i);
        freq.put(c,freq.getOrDefault(c,0)+1);
       }
       while(high<m){
        char c = s.charAt(high);
        if(freq.getOrDefault(c,0)>0){
            count++;
        }
        freq.put(c,freq.getOrDefault(c,0)-1);
        while(count==n){
            if(high-low+1 < len){
                len = high-low+1;
                startIdx = low;
            }
            char left = s.charAt(low);
            freq.put(left,freq.get(left)+1);
            if(freq.getOrDefault(left,0)>0){
                count--;
            }
            low++;
        }
        high++;
       }
       if(startIdx == -1){
        return "";
       }else{
        return s.substring(startIdx,len+startIdx);
       }
    }
}