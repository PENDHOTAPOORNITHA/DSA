class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1, high = 10000000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canReach(mid, dist, hour)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean canReach(int speed, int[] dist, double hour) {
        double time = 0;

        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }

        time += (double) dist[dist.length - 1] / speed;

        return time <= hour;
    }
}