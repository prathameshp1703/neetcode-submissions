class Solution {
    public int maxProduct(int[] nums) {
        int ans = (int) -1e9;
        int minProduct = 1; int maxProduct = 1;
        int size = nums.length;

        for(int i=0; i<size; i++){
            int temp = Math.min(nums[i], Math.min(maxProduct*nums[i], minProduct*nums[i]));
            maxProduct = Math.max(nums[i], Math.max(minProduct*nums[i], maxProduct*nums[i]));
            minProduct = temp;
            ans = Math.max(ans, Math.max(maxProduct, minProduct));
        }

        return ans;
    }
}
