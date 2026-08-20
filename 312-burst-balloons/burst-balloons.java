class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n + 2];
        arr[0] = arr[n+1] = 1;
        for(int i=1 ; i<=n ; i++){
            arr[i] = nums[i-1];
        }
        int dp[][] = new int[n+2][n+2];
        for(int len = 1 ; len <= n ; len++){
            for(int l = 1 ; l <= n - len + 1 ; l++){
                int r = l + len - 1;
                for(int i = l ; i <= r ; i++){
                    dp[l][r] = Math.max(dp[l][r] ,
                     dp[l][i-1] + dp[i+1][r] + (arr[l-1] * arr[i] * arr[r+1]));
                }
            }
        }
        return dp[1][n];
    }
}