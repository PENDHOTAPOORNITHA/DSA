
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long even = nums[0], odd = 0;
        for(int i = 1 ; i < n ; i++){
            long newEven = Math.max(even , odd + nums[i]);
            long newOdd = Math.max(odd, even-nums[i]);
            even = newEven;
            odd = newOdd;
        }
        return even;
    }
}