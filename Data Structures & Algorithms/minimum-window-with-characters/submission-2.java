class Solution {
    private Boolean checkValid(Map<Character, Integer> lookup, 
    Map<Character, Integer> expectedCounts){
        for(Map.Entry<Character, Integer> entry : expectedCounts.entrySet()){
            if(lookup.containsKey(entry.getKey()) && 
            lookup.get(entry.getKey()) >= entry.getValue()){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if(s.length()< t.length()){
            return "";
        }
        Map<Character, Integer> lookup = new HashMap<>();
        Map<Character, Integer> expectedCounts = new HashMap<>();

        int expectedSize = t.length();
        for(int i=0; i<expectedSize; i++){
            expectedCounts.put(t.charAt(i), expectedCounts.getOrDefault(t.charAt(i), 0)+1);
            lookup.put(s.charAt(i), lookup.getOrDefault(s.charAt(i), 0)+1);
        }

        int startIndex = -1; int endIndex = -1;
        
        int prevIndex = 0; int currIndex = expectedSize;
        int currMin = (int) 1e9;
        int size = s.length();
        if(checkValid(lookup, expectedCounts)){
            if(currIndex-prevIndex < currMin){
                currMin = currIndex-prevIndex+1;
                startIndex = prevIndex;
                endIndex = currIndex;
            }
        }
        
        while(currIndex < size){
            lookup.put(s.charAt(currIndex), lookup.getOrDefault(s.charAt(currIndex), 0)+1);
            
            while(checkValid(lookup, expectedCounts)){
                System.out.println(currIndex + " " + prevIndex);
                if(currIndex-prevIndex+1 < currMin){
                    currMin = currIndex-prevIndex+1;
                    startIndex = prevIndex;
                    endIndex = currIndex+1;
                }
                lookup.put(s.charAt(prevIndex), lookup.getOrDefault(s.charAt(prevIndex), 0)-1);
                prevIndex++;
            }
            currIndex++;
        }
        System.out.println("currMin " + currMin);
        String ans = "";
        if(startIndex != -1 && endIndex != -1){
            ans = s.substring(startIndex, endIndex);
        }

        return ans;
    }
}
