class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int left = 0;
        int right =people.length-1;
        while(left <=right){
            if(people[left]+people[right] <= limit){
            ans = ans+1;
            left++;
            right--;
            }else{
                right--;
                ans = ans+1;
            }
        }
        return ans;
    }
}