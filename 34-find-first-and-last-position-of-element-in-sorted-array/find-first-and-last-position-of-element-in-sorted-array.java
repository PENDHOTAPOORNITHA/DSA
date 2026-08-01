class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = BSLowerBound(0 , nums.length, nums, target);
        int last = BSLowerBound(0 , nums.length, nums, target+1) - 1;
        if(first <= last){
            return new int[]{first , last};
        }
        return new int[]{-1, -1};
    }
    public int BSLowerBound(int left, int right, int nums[], int target){
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}