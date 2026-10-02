class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        return wrap(n, ans , i , j ,sb);
    }
    public List<String> wrap(int n , ArrayList<String> ans , int i , int j ,  StringBuilder sb ){
        if(i == n && j == n){
            ans.add(sb.toString());
            return ans;
        }
        if(i<=n){
            sb.append('(');
            wrap(n , ans , i+1 , j , sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(j<i){
            sb.append(')');
            wrap(n , ans , i ,j+1 , sb);
            sb.deleteCharAt(sb.length()-1);
        }
        return ans;
    }
}