class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length, median, res = 0;
        Arrays.sort(nums);
        median = nums[n/2];
        for(int val : nums){
            res += Math.abs(val - median);
        }
        return res;
    }
}