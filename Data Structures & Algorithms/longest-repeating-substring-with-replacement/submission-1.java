class Solution {
    private boolean getMaxDiff(HashMap<Character, Integer> lookup, int mid, int k){
        int maxValue = -1;
        for(Map.Entry<Character, Integer> entry : lookup.entrySet()){
            maxValue = Math.max(maxValue, entry.getValue());
        }
        // System.out.println("mid " + mid + " maxValue" + maxValue);
        if(mid-maxValue <= k) return true;
        return false;
    }

    private boolean isPossible(int mid, String s, int k){
        HashMap<Character, Integer> lookup = new HashMap<>();
        for(int i=0; i<mid; i++){
            lookup.put(s.charAt(i), lookup.getOrDefault(s.charAt(i), 0)+1);
        }
        if(getMaxDiff(lookup, mid, k)) return true;
        for(int i=mid; i<s.length(); i++){
            lookup.put(s.charAt(i-mid), lookup.get(s.charAt(i-mid))-1);
            lookup.put(s.charAt(i), lookup.getOrDefault(s.charAt(i), 0)+1);
            if(getMaxDiff(lookup, mid, k)) return true;
        }
        return false;
    }

    public int characterReplacement(String s, int k) {
        int left = 0; int right = s.length();

        int ans = 0;

        while(left <= right){
            int mid = left +(right-left)/2;
            if(isPossible(mid, s, k)){
                ans = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        return ans;
    }
}
