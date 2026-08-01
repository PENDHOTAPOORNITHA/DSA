class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1 , high = 0;
        for(int val : piles)    high = Math.max(val , high);
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canFinish(mid , piles) <= (long)(h)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public long canFinish(int k, int piles[]){
        long hours = 0;
        for(int val : piles){
            hours += (val + k - 1)/k;
        }
        return hours;
    }

}