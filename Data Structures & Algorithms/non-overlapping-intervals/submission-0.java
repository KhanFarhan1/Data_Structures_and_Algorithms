class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int end1 = intervals[0][1];
        int count = 1;
        for(int i = 1;i<intervals.length;i++){
            int start2 = intervals[i][0];
            if(start2 >= end1){
                count++;
                end1 = intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}
