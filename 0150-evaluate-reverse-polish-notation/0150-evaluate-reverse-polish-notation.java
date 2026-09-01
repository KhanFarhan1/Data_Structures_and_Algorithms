class Solution {
    public int evalRPN(String[] token) {
       Stack<String> st = new Stack<>();
       for(int i = 0;i<token.length;i++){
        if(st.isEmpty()){
            st.push(token[i]);
        }else{
            if(token[i].equals("*") ||token[i].equals("+")||token[i].equals("-")||token[i].equals("/")){
                int var2 = Integer.parseInt(st.pop());
                int var1 = Integer.parseInt(st.pop());
                if(token[i].equals("+")){
                    st.push(String.valueOf(var1+var2));
                }else if(token[i].equals("-")){
                    st.push(String.valueOf(var1-var2));
                }else if(token[i].equals("*")){
                    st.push(String.valueOf(var1*var2));
                }else{
                    st.push(String.valueOf(var1/var2));
                }
            }else{
                st.push(token[i]);
            }
        }
       } 
       return Integer.parseInt(st.pop());
    }
}