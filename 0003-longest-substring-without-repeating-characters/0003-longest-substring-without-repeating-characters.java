class Solution {
    public int lengthOfLongestSubstring(String s) {
        int high = 0 ;
        int low = 0 ;
        int n = s.length();
        int ans = 0;
        HashMap<Character,Integer> freq = new HashMap<>();
        while(high<n){
            char c = s.charAt(high);
            freq.put(c,freq.getOrDefault(c,0)+1);
            while(freq.size() < (high-low+1)){
                char left = s.charAt(low);
                freq.put(left,freq.get(left)-1);
                if(freq.get(left)==0){
                    freq.remove(left);
                }
                low++;
            }
            ans = Math.max(ans,high-low+1);
            high++;
        }
        return ans;
    }
}