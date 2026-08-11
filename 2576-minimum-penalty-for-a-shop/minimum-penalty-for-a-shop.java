class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = customers.charAt(0) == 'N' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (customers.charAt(i) == 'N' ? 1 : 0);
        }
        suffix[n - 1] = customers.charAt(n - 1) == 'Y' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        int minPenalty = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int penalty;
            if (i == 0)
                penalty = suffix[0];
            else if (i == n)
                penalty = prefix[n - 1];
            else
                penalty = prefix[i - 1] + suffix[i];

            if (penalty < minPenalty) {
                minPenalty = penalty;
                ans = i;
            }
        }
        return ans;
    }
}