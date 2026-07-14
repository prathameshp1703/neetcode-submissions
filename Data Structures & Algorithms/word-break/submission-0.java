class Solution {

    private boolean wordBreakHelper(int index, String s, Map<String, Integer> lookup, int[] dp){
        int size = s.length();
        if(index >= size) return true;
        
        if(dp[index] != -1){
            return (dp[index] == 1) ? true : false;
        }
        boolean isPossible = false;
        for(int i=index; i<size; i++){
            String curr = s.substring(index, i+1);
            if(lookup.containsKey(curr)){
                isPossible = (isPossible || wordBreakHelper(i+1, s, lookup, dp));
            }
        }
        dp[index] = (isPossible == true) ? 1 : 0;
        return isPossible;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int index = 0;
        int size = s.length();
        int[] dp = new int[size];
        for(int i=0; i<size; i++){
            dp[i] = -1;
        }
        Map<String, Integer> lookup = new HashMap<>();
        for(String word : wordDict){
            lookup.put(word, 1);
        }
        return wordBreakHelper(index, s, lookup, dp);
    }
}
