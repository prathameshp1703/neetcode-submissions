class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0; int right=0;
        int currSum = 0;
        int size = nums.length;
        int ans = Integer.MAX_VALUE;

        while(right < size){
            currSum += nums[right];
            if(currSum < target){
                right++;
                continue;
            }
            else{
                while((currSum-nums[left]) >= target && left < right){
                    currSum -= nums[left];
                    left++;
                }
                // System.out.println(left + " " + right);
                ans = Math.min(ans, right-left+1);
            }
            right++;
        }
        if(ans == Integer.MAX_VALUE) ans = 0;
        return ans;
    }
}