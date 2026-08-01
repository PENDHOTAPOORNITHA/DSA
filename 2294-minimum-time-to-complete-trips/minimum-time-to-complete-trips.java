class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 1 , high = 0 , mid;
        for(int val : time){
            high = Math.max(val , high);
        }
        high *= totalTrips;
        while(low < high){
            mid = low + (high - low)/2;
            if(canCompleteTrips(mid , time, totalTrips)) {
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean canCompleteTrips(long t, int time[], int total){
        long trips = 0;
        for(int x : time){
            trips += t / x;
            if(trips >= total){
                return true;
            }
        }
        return trips >= total;
    }
}