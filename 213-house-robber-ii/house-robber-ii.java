
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int case1 = MaxMoney(0 , n-2, nums);
        int case2 = MaxMoney(1 , n-1, nums);
        return Math.max(case1 , case2);
    }
    public int MaxMoney(int left, int right, int nums[]){
        int prev1 = 0;
        int prev2 = 0;
        int curr = 0;
        for(int i=left ; i<=right ; i++){
            curr = Math.max(prev1 , prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}