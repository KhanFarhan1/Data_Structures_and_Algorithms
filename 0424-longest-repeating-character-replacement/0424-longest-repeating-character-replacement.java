class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0;
        int high = 0;
        int replace = 0;
        int ans = Integer.MIN_VALUE;
        int n = s.length();
        int maxfreq = 0;
        HashMap<Character ,Integer> freq = new HashMap<>();
        while(high<n){
            char c = s.charAt(high);
            freq.put(c,freq.getOrDefault(c , 0)+1);
            maxfreq = Math.max(maxfreq,freq.get(c));
            replace = (high-low+1)-maxfreq;
            while(replace>k){
                char left = s.charAt(low);
                freq.put(left,freq.get(left)-1);
                if(freq.get(left)==0){
                    freq.remove(left);
                }
                replace--;
                //replace = (high-low+1)-maxfreq;
                low++;
            }
            ans = Math.max(ans,high-low+1);
            high++;
        }
        return ans;
    }
}