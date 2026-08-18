class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> freq = new HashMap<>();
        int n = nums2.length;
        st.push(nums2[n-1]);
        freq.put(nums2[n-1] , -1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                freq.put(nums2[i] , -1);
            }else{
                freq.put(nums2[i] , st.peek());
            }
            st.push(nums2[i]);
        }
        for(int i =0;i<nums1.length;i++){
            ans[i] = freq.getOrDefault(nums1[i],0);
        }
        return ans;
    }
}