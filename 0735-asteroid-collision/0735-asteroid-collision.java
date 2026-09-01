class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       Stack <Integer> st = new Stack<>();
       for(int i = 0;i<asteroids.length;i++){
        if(st.isEmpty()){
            st.push(asteroids[i]);
        }else{
            if(st.peek() >0 && asteroids[i]<0){
                boolean destroyed = false;
                while(!st.isEmpty() && (st.peek() > 0 && asteroids[i]<0)){
                    int sum = st.peek() + asteroids[i];
                    if(sum > 0){
                        destroyed = true;
                        break;
                    }else if(sum==0){
                        st.pop();
                        destroyed = true;
                        break;
                    }else{
                        st.pop();
                    }
                }
                if(!destroyed){
                    st.push(asteroids[i]);
                }
                }else{
                st.push(asteroids[i]);
            }
        }
       }
       int [] ans = new int[st.size()];
       int i = st.size()-1;
       while(!st.isEmpty()){
        ans[i] = st.pop();
        i--;
       }
       return ans;
    }
}