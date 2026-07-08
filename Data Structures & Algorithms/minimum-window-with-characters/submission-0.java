class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int low = 0;
        int high = 0;
        int count = 0 ;
        int minlen = Integer.MAX_VALUE;
        int startIndex = -1;
        HashMap<Character , Integer> freq=new HashMap<>();
        for(int i = 0;i<m;i++){
            char c = t.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        while(high<n){
            char c = s.charAt(high);
            if(freq.getOrDefault(c,0)>0){
                count++;
            }
            freq.put(c,freq.getOrDefault(c,0)-1);
            while(count == m){
                if(high-low+1 < minlen){
                    minlen = high-low+1;
                    startIndex = low;
                }
                char left = s.charAt(low);
                freq.put(left,freq.get(left)+1);
                if(freq.get(left)>0){
                    count--;
                }
                low++;
            }
            high++;
        }
        if(startIndex == -1){
            return "";
        }else{
            return s.substring(startIndex , startIndex+minlen);
        }
    }
}
