/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start=1;
        int end=n;
        int least=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            boolean istrue=isBadVersion(mid);
            if(istrue==true){   //can be my potential answer
                least=mid;
                end=mid-1;      //go more lower to find the edge value
            }
            else
            start=mid+1;        //go higher to get wrong term
        }
        return least;   //returns the smallest index
    }
}