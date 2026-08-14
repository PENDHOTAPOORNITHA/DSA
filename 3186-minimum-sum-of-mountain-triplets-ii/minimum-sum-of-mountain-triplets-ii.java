class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int leftmin[] = new int[n];
        int rightmin[] = new int[n];
        leftmin[0] = nums[0];
        rightmin[n-1] = nums[n-1];
        for(int i = 1 ; i < n ; i++){
            leftmin[i] = Math.min(leftmin[i-1] , nums[i]);
        }
        for(int i = n - 2 ; i >=0 ; i--){
            rightmin[i] = Math.min(rightmin[i+1] , nums[i]);
        }
        int min_sum = Integer.MAX_VALUE;
        for(int i = 1 ; i < n-1 ; i ++){
            if(leftmin[i-1] >= nums[i] || rightmin[i+1] >= nums[i] ){
                continue;
            }
            else{
                min_sum = Math.min(min_sum , leftmin[i-1] + nums[i] + rightmin[i+1]);
            }
        }
        return min_sum == Integer.MAX_VALUE ? -1 : min_sum;
    }
}