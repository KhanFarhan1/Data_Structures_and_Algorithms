class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int high=0;
        int low =0;
        HashMap<Character,Integer> freq = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<p.length();i++){
            char c = p.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        while(high<s.length()){
            char c = s.charAt(high);
            window.put(c,window.getOrDefault(c,0)+1);
            while(high-low+1>p.length()){
                char left = s.charAt(low);
                window.put(left,window.get(left)-1);
                if(window.get(left)==0){
                    window.remove(left);
                }
                low++;
            }
            if(high-low+1 == p.length()){
                if(window.equals(freq)){
                    ans.add(low);
                }
            }
            high++;
        }
        return ans;
    }
}