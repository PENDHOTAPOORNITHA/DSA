class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        boolean[] present = new boolean[1001];
        boolean[] added = new boolean[1001];

        for (int n : nums1)
            present[n] = true;

        int count = 0;
        for (int n : nums2) {
            if (present[n] && !added[n]) {
                added[n] = true;
                count++;
            }
        }

        int[] result = new int[count];
        int idx = 0;

        for (int i = 0; i <= 1000; i++) {
            if (added[i])
                result[idx++] = i;
        }

        return result;
    }
}
