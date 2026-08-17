class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i =0;i<n;i++){
           char c = s.charAt(i);
           if(st.isEmpty()){
            st.push(c);
           }else{
            char d = st.peek();
            if(c == d){
                st.pop();
            }else{
                st.push(c);
            }
           }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        return sb.reverse().toString();
    }
}