class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a,b) -> a[0]-b[0]);
        int res = 0 , currEnd = 0 , End = 0 , i = 0;
        while(End < time){
            while(i < clips.length && clips[i][0] <= currEnd){
                End = Math.max(End , clips[i][1]);
                i++;
            }
            if(currEnd == End)  return -1;
            res++;
            currEnd = End;
        }
        return res;
    }
}