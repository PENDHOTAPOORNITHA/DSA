class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int arr[] = new int[m + 2];
        arr[0] = 0;     arr[m+1] = n;
        for(int i = 1 ; i <= m ; i++){
            arr[i] = cuts[i - 1];
        }
        int dp[][] = new int[m + 2][m + 2];
        for(int len = 1 ; len <= m ; len++){
            for(int l = 1 ; l <= m - len + 1 ; l++){
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for(int i = l ; i <= r ; i++){
                    int cost = dp[l][i-1] + dp[i+1][r] + arr[r+1] - arr[l-1];
                    dp[l][r] = Math.min(cost , dp[l][r]);
                }
            }
        }
        return dp[1][m];
    }
}