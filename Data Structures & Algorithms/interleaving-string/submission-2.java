class Solution {

    private boolean isInterleaveHelper(int index1, int index2,
        String s1, String s2, String s3, int[][] dp){
        if(index1 == s1.length() || index2 == s2.length()){
            
            if(index1 != s1.length()){
                while(index1 < s1.length() && (index1+index2) < s3.length()){
                    if(s1.charAt(index1) != s3.charAt(index1+index2)){
                        return false;
                    }
                    index1++;
                }
            }
            else{
                while(index2 < s2.length() && (index1+index2) < s3.length()){
                    if(s2.charAt(index2) != s3.charAt(index1+index2)){
                        return false;
                    }
                    index2++;
                }
            }

            return (index1 == s1.length() && index2 == s2.length() && (index1+index2) == s3.length());
        }
        if(dp[index1][index2] != -1){
            return (dp[index1][index2] == 1) ? true : false;
        }
        
        boolean curr = false;
        if((index1+index2) < s3.length() && s1.charAt(index1) == s3.charAt(index1+index2)){
            curr = curr || isInterleaveHelper(index1+1, index2, s1, s2, s3, dp);
        }
        if((index1+index2) < s3.length() && s2.charAt(index2) == s3.charAt(index1+index2)){
            curr = curr || isInterleaveHelper(index1, index2+1, s1, s2, s3, dp);
        }
        dp[index1][index2] = (curr == true) ? 1 : 0;
        return curr;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int index1 = 0; int index2 = 0; int index3 = 0;
        int sizeS1 = s1.length(); int sizeS2 = s2.length();
        int sizeS3 = s3.length();
        int[][] dp = new int[sizeS1][sizeS2];

        for(int i=0; i<sizeS1; i++){
            for(int j=0; j<sizeS2; j++){
                dp[i][j] = -1;
            }
        }
        return isInterleaveHelper(index1, index2, s1, s2, s3, dp);
    }
}
