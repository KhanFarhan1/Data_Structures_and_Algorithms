class Solution {
    public int minfun(int n){
        int sum = 0;
        while(n>0){
            int dig = n%10;
            n=n/10;
            sum += dig*dig;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(fast != 1){
            slow = minfun(slow);
            fast = minfun(minfun(fast));
            
            if(slow == fast && slow != 1){
                return false;
            }
        }
        return true;
    }
}
