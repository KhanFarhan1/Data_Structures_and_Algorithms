class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int high = 0 ;
        int low = 0;
        HashMap<Character,Integer> freq = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(int i =0;i<s1.length();i++){
            char c = s1.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        while(high<s2.length()){
            char c = s2.charAt(high);
            window.put(c,window.getOrDefault(c,0)+1);
            while(high-low+1 > s1.length()){
                char left = s2.charAt(low);
                window.put(left,window.get(left)-1);
                if(window.get(left)==0){
                    window.remove(left);
                }
                low++;
            }
            if(high-low+1 == s1.length()){
                if(window.equals(freq)){
                    return true;
                }
            }
            high++;
        }
        return false;
    }
}