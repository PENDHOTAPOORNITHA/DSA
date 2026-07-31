class Solution {
    public int deleteAndEarn(int[] nums) {
        int Max = 0;
        for(int val : nums) Max = Math.max(val , Max);

        int points[] = new int[Max + 1];
        for(int val : nums) points[val] += val;
        int prev2 = 0;
        int prev1 = points[0];
        int curr = 0;
        for(int i = 1 ; i <= Max ; i++){
            curr = Math.max(prev1 , prev2 + points[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}