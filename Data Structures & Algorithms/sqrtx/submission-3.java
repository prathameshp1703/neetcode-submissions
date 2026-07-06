class Solution {
    public int mySqrt(int x) {
        long left = 0; long right = (long) (x/2) + 1;
        int ans = -1;
        while(left <= right){
            long mid = left + (right-left)/2;
            long curr = mid*mid;
            if(curr == x){
                ans = (int) mid;
                break;
            }
            else if(curr > x){
                right = mid-1;
            }
            else{
                ans = (int) mid;
                left = mid+1;
            }
        }

        return ans;
    }
}