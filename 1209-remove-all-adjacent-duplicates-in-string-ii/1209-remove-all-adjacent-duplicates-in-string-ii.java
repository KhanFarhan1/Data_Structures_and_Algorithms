class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Object[]> st = new Stack<>();
        for(int i = 0;i<n;i++){
            if(st.isEmpty()){
                char c = s.charAt(i);
                st.push(new Object[]{c ,1});
            }else{
                char top_elm = (char)st.peek()[0];
                int count = (int)st.peek()[1];
                char c = s.charAt(i);
                // if(c == top_elm && count < k-1){
                //     st.pop();
                //     st.push(new Object[]{c , count++});
                // }else if(c != top_elm){
                //     st.push(new Object[]{c , 1});
                // }else if(c == top_elm && count == k-1){
                //     st.pop();
                // }
                if(c != top_elm){
                    st.push(new Object[]{c , 1});
                }else if(c == top_elm && count != k-1){
                    st.pop();
                    count = count +1;
                    st.push(new Object[]{c , count});
                }else{
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            int count = (int)st.peek()[1];
            for(int i = 0;i<count;i++){
                sb.append(st.peek()[0]);
            }
            st.pop();
        }
        return sb.reverse().toString();
    }
}