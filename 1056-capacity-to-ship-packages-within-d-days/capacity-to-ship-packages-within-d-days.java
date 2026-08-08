
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        for(int val : weights){
            sum += val;
            max = Math.max(max , val);
        }
        int low = max , high = sum;
        while(low < high){
            int mid = low + (high - low)/2;
            int d = DaysToTransport(mid , weights);
            if(d <= days){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public int DaysToTransport(int MaxCapacity, int weights[]){
        int days = 1, capacity = 0;
        for(int w : weights){
            if(capacity + w > MaxCapacity){
                days++;
                capacity = 0;
            }
            capacity += w;
        }
        return days;
    }
}