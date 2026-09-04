class Solution {
    public int maxNumberOfBalloons(String text) {
        String str = "balloon";
        if(text.length() < str.length()){
            return 0;
        }
       HashMap<Character , Integer> freq_balloon = new HashMap<>();
       HashMap<Character , Integer> freq_str = new HashMap<>();
       for(int i = 0;i<str.length();i++){
        char ch = str.charAt(i);
        freq_balloon.put(ch , freq_balloon.getOrDefault(ch,0)+1);
       }
       for(int i = 0;i<text.length();i++){
        char ch = text.charAt(i);
        freq_str.put(ch , freq_str.getOrDefault(ch,0)+1);
       }
       int ans = Integer.MAX_VALUE;
       for(int i = 0;i<str.length();i++){
        char ch = str.charAt(i);
        int freq_str_ith = freq_str.getOrDefault(ch,0);
        int freq_balloon_ith = freq_balloon.getOrDefault(ch,0);
        if(freq_balloon_ith >0){
            ans = Math.min(ans , freq_str_ith/freq_balloon_ith);
        }
       }
       return ans;
    }
}