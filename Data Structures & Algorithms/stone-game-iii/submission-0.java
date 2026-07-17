class Solution {

    private int stoneGameHelper(int index, int[] stoneValue, int[] dp){
        if(index == stoneValue.length){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }
        int takeFirst = Integer.MIN_VALUE;
        int takeSecond = Integer.MIN_VALUE;
        int takeThird = Integer.MIN_VALUE;

        takeFirst = stoneValue[index] - stoneGameHelper(index+1, stoneValue, dp);
        if(index+1 < stoneValue.length){
            takeSecond = stoneValue[index]+stoneValue[index+1] - stoneGameHelper(index+2, stoneValue, dp);
        }
        if(index+2 < stoneValue.length){
            takeThird = stoneValue[index]+stoneValue[index+1]+stoneValue[index+2] - stoneGameHelper(index+3, stoneValue, dp);
        }
        
        return dp[index] = Math.max(takeFirst, Math.max(takeSecond, takeThird));
    }

    public String stoneGameIII(int[] stoneValue) {
        int index = 0;
        int size = stoneValue.length;
        int[] dp = new int[size+1];
        for(int i=0; i<=size; i++){
            dp[i] = -1;
        }
        int val = stoneGameHelper(index, stoneValue, dp);
        if(val>0) return "Alice";
        else if(val<0) return "Bob";
        return "Tie";
    }
}