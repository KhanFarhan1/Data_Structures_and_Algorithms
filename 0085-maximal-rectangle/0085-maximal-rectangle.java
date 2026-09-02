class Solution {
    public int histogram(int[] arr){
        int n = arr.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        Stack<Integer> st = new Stack<>();
        int ans = Integer.MIN_VALUE;
        //nsl
        nsl[0] = -1;
        st.push(0);
        for(int i = 1;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                    st.pop();
            }
            if(!st.isEmpty()){
                nsl[i]= st.peek();
            }else{
                nsl[i]= -1;
            }
            st.push(i);
            }
        
        //nsr
        st = new Stack<>();
        nsr[n-1]= n;
        st.push(n-1);
        for(int i = n-2;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i] = n;
            }else{
                nsr[i] = st.peek();
            }
            st.push(i);
        }
        //calculation
        for(int i = 0;i<arr.length;i++){
            int curr = arr[i]*(nsr[i]-nsl[i]-1);
            ans = Math.max(ans , curr);
        }
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
       int n = matrix.length;//row
       int m = matrix[0].length;//col
       int ans = Integer.MIN_VALUE;
       int[][] pSum = new int[n][m]; 
       for(int j=0;j<m;j++){
        int sum = 0;
        for(int i = 0;i<n;i++){
            int matrix_val = Character.getNumericValue(matrix[i][j]);
            sum = sum+matrix_val;
            if(matrix_val == 0){
                sum = 0;
            }
            pSum[i][j] = sum;
        }
       }
       for(int i = 0;i<n;i++){
        ans = Math.max(ans , histogram(pSum[i]));
       }
       return ans;
    }
}