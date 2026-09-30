class Solution {
    public List<String> wrap(String digits , ArrayList ans , HashMap<Character , String> freq , StringBuilder sb , int index ){
        if(digits.length() == sb.length()){
            ans.add(sb.toString());
            return ans;
        }
        char c = digits.charAt(index);
        String choices = freq.get(c);
        for(int j = 0; j<choices.length() ; j++){
            sb.append(choices.charAt(j));
            wrap(digits , ans , freq , sb , index+1);
            sb.deleteCharAt(sb.length()-1);
        }
        return ans;
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character , String> freq = new HashMap<>();
        freq.put('2' , "abc");
        freq.put('3' , "def");
        freq.put('4' , "ghi");
        freq.put('5' , "jkl");
        freq.put('6' , "mno");
        freq.put('7' , "pqrs");
        freq.put('8' , "tuv");
        freq.put('9' , "wxyz");
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        return wrap(digits , ans , freq , sb , 0 );
    }
}