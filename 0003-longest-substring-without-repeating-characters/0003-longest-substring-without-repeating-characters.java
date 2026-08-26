class Solution {
    public int lengthOfLongestSubstring(String s) {
        int high = 0;
        int low = 0;
        int n = s.length();
        int ans  = 0;
        HashMap<Character , Integer> freq = new HashMap<>();
        while(high<n){
            char c = s.charAt(high);
            freq.put(c, freq.getOrDefault(c,0)+1);
            while((high-low+1) > freq.size()){
                char lower = s.charAt(low); 
                freq.put(lower , freq.get(lower)-1);
                if(freq.get(lower) == 0){
                    freq.remove(lower);
                }
                low++;
            }
            ans = Math.max(ans , high-low+1);
            high++;
        }
        return ans;
    }
}