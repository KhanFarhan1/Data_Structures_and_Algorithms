class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(st.isEmpty()){
                st.push(c);
            }else{
                char d = st.peek();
                if((d == '[' && c == ']')||(d == '{' && c == '}')||(d == '(' && c == ')')){
                    st.pop();
                }else{
                    st.push(c);
                }
            }
        }
        return st.isEmpty();
    }
}