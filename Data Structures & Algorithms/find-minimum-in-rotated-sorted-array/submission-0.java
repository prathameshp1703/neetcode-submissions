class Solution {
    public int findMin(int[] nums) {
        int size = nums.length;
        int left = 0; int right = size-1;
        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left +(right-left)/2;
            if(nums[left] <= nums[mid]){
                ans = Math.min(ans, nums[left]);
                left = mid+1;
            }
            else if(nums[mid]<=nums[right]){
                ans = Math.min(ans, nums[mid]);
                right = mid-1;
            }
        }
        return ans;
    }
}
