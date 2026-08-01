class Solution {
    public int searchInsert(int[] nums, int target) {
        return BinarySearch(0,nums.length-1,nums,target);
        
    }
    public int BinarySearch(int l,int r,int nums[],int t){
        if(l>r){
            return l;
        }
        int mid=l+(r-l)/2;
        if(nums[mid]==t){
            return mid;
        }
        else if(nums[mid]>t){
            return BinarySearch(l,mid-1,nums,t);
        }
        else{
            return BinarySearch(mid+1,r,nums,t);
        }
    }
}