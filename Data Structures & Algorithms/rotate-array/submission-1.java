class Solution {
    private void reverse(int start, int end, int[] nums){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int start = 0 ; int end = nums.length-1;
        reverse(start, end, nums);

        start = 0; end = k -1;
        reverse(start, end, nums);

        start = k; end = nums.length-1;
        reverse(start, end, nums);
    }
}