/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        if(intervals.size()==0){
            return true;
        }
        int start1 = intervals.get(0).start;
        int end1 = intervals.get(0).end;
        for(int i =1;i<intervals.size();i++){
            int start2 = intervals.get(i).start;
            int end2 = intervals.get(i).end;
            if(end1 > start2){
                return false;
            }
            start1 = start2;
            end1=end2;
        }
        return true;
    }
}
