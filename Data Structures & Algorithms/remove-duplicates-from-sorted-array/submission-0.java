class Solution {
    private void swap(int curr, int next, int[] nums){
        int temp = nums[curr];
        nums[curr] = nums[next];
        nums[next] = temp;
    }
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int curr = 0; int next = curr+1;

        while(next < size){
            if(nums[curr] != nums[next]){
                curr++;
                swap(curr, next, nums);
                next++;
            }
            else{
                next++;
            }
        }

        return curr+1;
    }
}