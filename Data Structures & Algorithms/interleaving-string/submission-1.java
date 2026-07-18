class Solution {

    private boolean isInterleaveHelper(int index1, int index2, int index3, 
        String s1, String s2, String s3, int prev, int[][][][] dp){
        
        if(index1 == s1.length() || index2 == s2.length() || index3 == s3.length()){
            if(index1 == s1.length()){
                while(index2<s2.length() && index3<s3.length()){
                    if(s2.charAt(index2) != s3.charAt(index3)){
                        return false;
                    }
                    index2++; index3++;
                }
            }
            else if(index2 == s2.length()){
                while(index1<s1.length() && index3<s3.length()){
                    if(s1.charAt(index1) != s3.charAt(index3)){
                        return false;
                    }
                    index1++; index3++;
                }
            }

            return (index1 == s1.length() && index2 == s2.length() && index3 == s3.length());
        }

        if(dp[index1][index2][index3][prev] != -1){
            return dp[index1][index2][index3][prev] == 1 ? true : false;
        }
        boolean curr = false;
        int currIndex1 = index1; int currIndex2 = index2;
        int currIndex3 = index3;
        if(prev == 1){
            while(currIndex1 < s1.length() && currIndex3<s3.length()){
                if(s1.charAt(currIndex1) == s3.charAt(currIndex3)){
                    curr = curr || isInterleaveHelper(currIndex1+1, currIndex2, currIndex3+1, s1, s2, s3, 0, dp);
                    currIndex1++; currIndex3++;
                }
                else{
                    break;
                }
            }
        }
        else{
            while(currIndex2 < s2.length() && currIndex3<s3.length()){
                if(s2.charAt(currIndex2) == s3.charAt(currIndex3)){
                    curr = curr || isInterleaveHelper(currIndex1, currIndex2+1, currIndex3+1, s1, s2, s3, 1, dp);
                    currIndex2++; currIndex3++;
                }
                else{
                    break;
                }
            }
        }
        dp[index1][index2][index3][prev] = (curr == true) ? 1 : 0;
        return curr;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int index1 = 0; int index2 = 0; int index3 = 0;
        int sizeS1 = s1.length(); int sizeS2 = s2.length(); int sizeS3 = s3.length();
        int[][][][] dp = new int[sizeS1][sizeS2][sizeS3][2];

        for(int i=0; i<sizeS1; i++){
            for(int j=0; j<sizeS2; j++){
                for(int k=0; k<sizeS3; k++){
                    for(int l=0; l<2; l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return (isInterleaveHelper(index1, index2, index3, s1, s2, s3, 1, dp) || 
        isInterleaveHelper(index1, index2, index3, s1, s2, s3, 0, dp));
    }
}
