class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int min  = 0 , p = 0 , max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < pivot){
                min++;
            }
            else if(nums[i] > pivot){
                max++;
            }
            else{
                p++;
            }
        }
        int index1 = 0 , index2 = min, index3 = min+ p;
        int arr[] = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < pivot){
                arr[index1++] = nums[i];
            }
            else if(nums[i] > pivot){
                arr[index3++] = nums[i];
            }
            else{
                arr[index2++] = nums[i];
            }
        }
        return arr;
    }
}