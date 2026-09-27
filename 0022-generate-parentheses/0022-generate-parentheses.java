class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        return wrap(n , i , j ,ans,sb);
    }
    public List<String> wrap(int n , int i , int  j ,List<String> ans , StringBuilder sb){
        if(i == n && j == n){
            ans.add(sb.toString());
        }
        if(i<=n){
            sb.append('(');
            wrap(n , i+1 , j , ans , sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(j<i){
            sb.append(')');
            wrap(n , i , j+1 , ans , sb);
            sb.deleteCharAt(sb.length()-1);
        }
        return ans;
    }
}