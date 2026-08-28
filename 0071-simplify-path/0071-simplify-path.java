class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack <String> st = new Stack<>();
        for(int i = 0;i<str.length;i++){
            if(str[i].equals("..")){
                if(!st.isEmpty()){
                st.pop();
                }
                continue;
            }
            if(str[i].equals("") || str[i].equals(".")){
                continue;
            }
            st.push(str[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,"/"+st.peek());
            st.pop();
        }
        if(sb.length()==0){
            return "/";
        }
        return sb.toString();
    }
}