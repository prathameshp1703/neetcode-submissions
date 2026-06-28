class Solution {

    private boolean isPossible(int mid, int[] weights, int days){
        int count = 1;
        int size = weights.length;
        int currWeight = 0;
        for(int i=0; i<size; i++){
            if(weights[i] > mid) return false;
            currWeight += weights[i];
            if(currWeight > mid){
                currWeight = weights[i];
                count++;
            }
        }
        return count <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int ans = 0;
        int left = 0; int right = Integer.MAX_VALUE-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(isPossible(mid, weights, days)){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return ans;
    }
}