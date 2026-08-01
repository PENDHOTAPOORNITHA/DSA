/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return BinarySearch(1,n);   
    }
    public int BinarySearch(int left,int right){
        while(left<right){
            int mid=left+(right-left)/2;
            if(isBadVersion(mid)){
                right=mid; 
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}