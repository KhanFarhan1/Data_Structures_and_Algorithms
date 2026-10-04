class Solution {
    public List<List<String>> partition(String s) {
        List<String> sub = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        return wrap(s , sub , ans , sb , 0);
    }
    public List<List<String>> wrap(String s , List<String> sub , List<List<String>> ans , StringBuilder sb , int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(sub));
            return ans;
        }
        for(int i = index ; i<s.length();i++){
            sb.append(s.charAt(i));
            if(ispalindrome(sb)){
                sub.add(sb.toString());
                StringBuilder sb1 = new StringBuilder();
                wrap(s,sub,ans,sb1,i+1);
                sub.remove(sub.size()-1);
            }
        }
        return ans;
    }
    public boolean ispalindrome(StringBuilder sb){
        int left = 0;
        int right = sb.length()-1;
        while(left<=right){
            if(sb.charAt(left) == sb.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}