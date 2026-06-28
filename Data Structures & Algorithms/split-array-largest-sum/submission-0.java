class Solution {
    private boolean isPossible(int mid, int[] nums, int k){
        int size = nums.length;
        int count = 1;
        int currSum = 0;
        for(int i=0; i<size; i++){
            if(nums[i] > mid) return false;
            currSum += nums[i];
            if(currSum > mid){
                currSum = nums[i];
                count++;
            }
        }
        return count <= k;
    }

    public int splitArray(int[] nums, int k) {
        int ans = -1;
        int left = 0; int right = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right-left)/2;

            if(isPossible(mid, nums, k)){
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