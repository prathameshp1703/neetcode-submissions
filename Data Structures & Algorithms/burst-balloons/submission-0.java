class Solution {

    private int maxCoinsHelper(int index1, int index2, List<Integer> nums, int[][] dp){

        if(index1 == index2) return nums.get(index1-1) * nums.get(index1) * nums.get(index2+1);

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        int ans = 0;
        for(int i=index1; i<=index2; i++){
            int curr = nums.get(index1-1) * nums.get(i) * nums.get(index2+1);
            ans = Math.max(ans, curr + maxCoinsHelper(index1, i-1, nums, dp)
             + maxCoinsHelper(i+1, index2, nums, dp));
        }

        return dp[index1][index2] = ans;
    }

    public int maxCoins(int[] nums) {
        List<Integer> newNums = new ArrayList<>();
        newNums.add(1);
        for(int i=0; i<nums.length; i++){
            newNums.add(nums[i]);
        }
        newNums.add(1);
        int size = newNums.size();
        int[][] dp = new int[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                dp[i][j] = -1;
            }
        }

        int index1 = 1; int index2 = newNums.size()-2;
        return maxCoinsHelper(index1, index2, newNums, dp);
    }
}
