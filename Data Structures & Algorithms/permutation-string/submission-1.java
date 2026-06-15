class Solution {
    private boolean checkEquality(List<Integer> occ, List<Integer> curr){
        boolean exists = true;
        for(int i=0; i<26; i++){
            if(occ.get(i) != curr.get(i)){
                exists = false;
            }
        }
        return exists;
    }

    public boolean checkInclusion(String s1, String s2) {
        List<Integer> occ = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for(int i=0; i<26; i++){
            occ.add(0);
            curr.add(0);
        }
        if(s2.length()<s1.length()) return false;
        int windowSize = s1.length();
        for(int i=0; i<windowSize; i++){
            occ.set(s1.charAt(i)-'a', occ.get(s1.charAt(i)-'a')+1);
            curr.set(s2.charAt(i)-'a', curr.get(s2.charAt(i)-'a')+1);
        }

        if(checkEquality(occ, curr)) return true;
        for(int i=windowSize; i<s2.length(); i++){
            curr.set(s2.charAt(i-windowSize)-'a', curr.get(s2.charAt(i-windowSize)-'a')-1);
            curr.set(s2.charAt(i)-'a', curr.get(s2.charAt(i)-'a')+1);

            if(checkEquality(occ, curr)) return true;
        }

        return false;
    }
}
