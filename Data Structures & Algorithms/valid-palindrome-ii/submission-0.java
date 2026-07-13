class Solution {

    private boolean isPal(String s1){
        int start = 0; int end = s1.length()-1;
        while(start < end){
            if(s1.charAt(start) == s1.charAt(end)){
                start++; end--;
            }
            else{
                return false;
            }
        }

        return true;
    }
    public boolean validPalindrome(String s) {
        int start = 0; int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else{
                return isPal(s.substring(start+1, end+1)) || isPal(s.substring(start, end));
            }
        }

        return true;
    }
}