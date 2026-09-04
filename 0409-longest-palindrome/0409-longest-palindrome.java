class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character , Integer> freq = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            freq.put(ch , freq.getOrDefault(ch , 0)+1);
        }
        int ans = 0;
        Boolean isOdd = false;
        for(char ch: freq.keySet()){
            int num = freq.get(ch);
            if(num%2 == 0){
                ans = ans + freq.get(ch);
            }else{
                isOdd = true;
            }
        }
        if(!isOdd){
            return ans;
        }
        for(char ch: freq.keySet()){
            int num2 = freq.get(ch);
            if(num2 % 2 != 0){
                ans = ans + freq.get(ch)-1;
            }
        }
        return ans+1;
    }
}