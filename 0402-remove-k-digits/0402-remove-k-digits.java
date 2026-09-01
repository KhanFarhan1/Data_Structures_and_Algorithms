class Solution {
    public String removeKdigits(String num, int k) {
        Stack <Integer> st = new Stack<>();
        for(int i  = 0;i<num.length();i++){
            char c = num.charAt(i);
            int ith_num = Character.getNumericValue(c); 
            while(!st.isEmpty()&& k>0 && ith_num < st.peek()){
              st.pop();
              k--;  
            }
            st.push(ith_num);
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}