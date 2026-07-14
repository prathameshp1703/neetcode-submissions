class Solution {
    private int numDecodingsHelper(int index, String s, Map<Integer, String> lookup, int[] dp){
        if(index == s.length()){
            return 1;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int count = 0;
        for(int i=index; i<s.length(); i++){
            String curr = s.substring(index, i+1);
            Integer currVal = Integer.valueOf(curr);
            if(currVal>26 || currVal<=0) break;
            count += numDecodingsHelper(i+1, s, lookup, dp);
        }

        return dp[index] = count;
    }

    public int numDecodings(String s) {
        Map<Integer, String> lookup = new HashMap<>();
        for(int i=0; i<26; i++){
            char curr = (char) ('A' + i);
            lookup.put(i+1, String.valueOf(curr));
        }

        int index = 0;
        int [] dp = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            dp[i] = -1;
        }
        return numDecodingsHelper(index, s, lookup, dp);
    }
}
