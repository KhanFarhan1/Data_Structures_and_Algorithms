class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c != ']'){
                st.push(c);
            }else{
                StringBuilder sb = new StringBuilder();
                while(st.size() >0 && st.peek() != '['){
                    sb.insert(0,st.peek());
                    st.pop();
                }
                st.pop();
                String str = sb.toString();
                sb = new StringBuilder();
                while(st.size()>0 && st.peek() >= '0' && st.peek() <= '9' ){
                    sb.insert(0,st.peek());
                    st.pop();
                }
                int count = Integer.parseInt(sb.toString());
                while(count >0){
                    for(int j =0;j<str.length();j++){
                        char ch = str.charAt(j);
                        st.push(ch);
                    }
                    count--;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.insert(0,st.pop());
        }
        return ans.toString();
    }
}