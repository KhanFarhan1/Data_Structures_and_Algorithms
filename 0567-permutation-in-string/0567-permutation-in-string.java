class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int high = 0;
        int low = 0;
        int count = 0;
        HashMap<Character , Integer> freq = new HashMap<>();
        HashMap<Character , Integer> window = new HashMap<>();
        for(int i = 0;i<n;i++){
            char c = s1.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        while(high<m){
            char c = s2.charAt(high);
            window.put(c,window.getOrDefault(c,0)+1);
            while(high-low+1 > n){
                char left = s2.charAt(low);
                window.put(left,window.get(left)-1);
                if(window.get(left)==0){
                    window.remove(left);
                }
                low++;
            }
            if(high-low+1==n){
                if(window.equals(freq)){
                    return true;
                }
            }
           high++; 
        }
        return false;
    }
}