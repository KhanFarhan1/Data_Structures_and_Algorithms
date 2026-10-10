class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int old_x = x;
        int new_x = 0;
        while(x > 0){
            int digit = x % 10;
            new_x = new_x*10 + digit ;
            x = x/10;
        }
        if(new_x == old_x){
            return true;
        }else{
            return false;
        }
    }
}