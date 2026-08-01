class Solution {
    public int maximumCandies(int[] candies, long k) {
        long low = 1 , high = 0 , mid, sum = 0;
        for(int val : candies){
            sum += val;
            high = Math.max(high , val);
        }
        if(sum < k) return 0;
        while(low < high){
            mid = low + (high - low + 1)/2;
            if(canDistribute(mid , candies , k)){
                low = mid;
            }
            else{
                high = mid - 1;
            }
        }
        return (int)(low);
    }
    public boolean canDistribute(long candy, int candies[], long k){
        long children = 0;
        for(int x : candies){
            children += x / candy;
            if(children >= k){
                return true;
            }
        }
        return children >= k;
    }
}