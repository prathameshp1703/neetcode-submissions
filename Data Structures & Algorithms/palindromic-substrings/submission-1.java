class Solution {
    private boolean isPal(int index1, int index2, String s){
        int startIndex = index1; int endIndex = index2-1;
        while(startIndex < endIndex){
            if(s.charAt(startIndex) != s.charAt(endIndex)){
                return false;
            }
            startIndex++; endIndex--;
        }
        return true;
    }

    private int solve(int curr, String s, int[] dp){
        if(curr >= s.length()){
            return 0;
        }
        if(dp[curr] != -1){
            return 0;
        }
        int count = 0;
        for(int i=curr; i<s.length(); i++){
            if(isPal(curr, i+1, s)){
                count += (1+solve(i+1, s, dp));
            }
        }
        return dp[curr] = count;
    }

    public int countSubstrings(String s) {
        int curr = 0;
        int size = s.length();
        int[] dp = new int[size];

        for(int i=0; i<size; i++){
            dp[i] = -1;
        }

        return solve(curr, s, dp);
    }
}
