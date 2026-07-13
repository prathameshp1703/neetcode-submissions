class Solution {
    public String mergeAlternately(String word1, String word2) {
        int size1 = word1.length();
        int size2 = word2.length();
        int start1 = 0; int start2 = 0;
        StringBuilder sb = new StringBuilder();
        while(start1 < size1 && start2 < size2){
            sb.append(word1.charAt(start1));
            sb.append(word2.charAt(start2));
            start1++;
            start2++;
        }   
        if(start1 < size1){
            String rem = word1.substring(start1, size1);
            sb.append(rem);
        }
        else{
            String rem = word2.substring(start2, size2);
            sb.append(rem);
        }

        return sb.toString();
    }
}