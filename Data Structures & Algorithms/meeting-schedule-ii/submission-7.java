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

// class Solution {
//     public int minMeetingRooms(List<Interval> intervals) {
//         if(intervals.size()==0){
//             return 0;
//         }else if(intervals.size()==1){
//             return 1;
//         }
//         int start1 = intervals.get(0).start;
//         int end1 = intervals.get(0).end;
//         int ans = 0;
//         for(int i = 1;i<intervals.size();i++){
//             int start2 = intervals.get(i).start;
//             int end2 = intervals.get(i).end;
//             if(end1 <= start2){
//                 start1 = start2;
//                 end1 = end2;
//                 continue;
//             }
//             ans++;
//             start1 = start2;
//             end1=end2;
//         } 
//         ans++;
//         return ans;
//     }
// }

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        int count = 0;
        int res = 0;
        for(int i = 0;i<intervals.size();i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int start_pointer = 0;
        int end_pointer = 0;
        while(start_pointer < start.length){
            if(start[start_pointer] < end[end_pointer]){
                count++;
                start_pointer++;
            }else{
                count--;
                end_pointer++;
            }
            res = Math.max(count , res);
        }
        return res;
    }
}
