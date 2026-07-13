class Solution {
    public String longestPalindrome(String s) {
        int start = 0; int palSize = 1;
        int size = s.length();

        int[][] dp = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                dp[i][j] = -1;
            }
        }

        for(int i=0; i<size-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                start = i; palSize = 2;
            }
        }

        for(int i=3; i<=size; i++){
            for(int j=0; j<=(size-i); j++){
                int currStart = j; int currEnd = currStart+i-1;
                boolean isPal = true;
                while(currStart < currEnd){
                    if(dp[currStart][currEnd] != -1){
                        break;
                    }
                    if(s.charAt(currStart) != s.charAt(currEnd)){
                        isPal = false; break;
                    }
                    currStart++; currEnd--;
                }
                if(isPal == true){
                    // System.out.println(j + " " + (j+i-1));
                    dp[j][j+i-1] = 1;
                    start = j; palSize = i;
                }
            }
        }
        String ans = s.substring(start, start + palSize);

        return ans;
    }
}
