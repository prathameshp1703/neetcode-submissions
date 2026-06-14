class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lookup = new HashMap<>();

        int ans = 0;
        int index = 0;
        int prevIndex = 0;
        while(index<s.length()){
            if(!lookup.containsKey(s.charAt(index))){
                lookup.put(s.charAt(index), index);
                index++;
            }
            else{
                int temp = lookup.get(s.charAt(index));
                while(prevIndex<=temp){
                    lookup.remove(s.charAt(prevIndex));
                    prevIndex++;
                }
                lookup.put(s.charAt(index), index);
                index++;
            }
            ans = Math.max(ans, index-prevIndex);
        }
        return ans;
    }
}
