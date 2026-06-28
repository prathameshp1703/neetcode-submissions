class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int start = 1; int end = numbers.length;
        while(start < end){
            int currSum = numbers[start-1] + numbers[end-1];
            if(currSum == target){
                ans[0] = start;
                ans[1] = end;
                return ans;
            }
            else if(currSum > target){
                end--;
            }
            else{
                start++;
            }
        }

        return ans;
    }
}
