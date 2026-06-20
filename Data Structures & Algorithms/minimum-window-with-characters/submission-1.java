class Solution {
    private Boolean checkValid(Map<Character, Integer> curr, Map<Character, Integer> req){
        for(Map.Entry<Character, Integer> entry : req.entrySet()){
            Character key = entry.getKey();
            
            if(curr.containsKey(key) && curr.get(key) >= entry.getValue()){
                continue;
            }
            else{
                // System.out.println(key);
                return false;
            }
        }
        return true;
    }
    
    public String minWindow(String s, String t) {
        int ssize = s.length();
        int tsize = t.length();

        Map<Character, Integer> curr = new HashMap<>();
        Map<Character, Integer> req  = new HashMap<>();

        for(int i=0; i<tsize; i++){
            req.put(t.charAt(i), req.getOrDefault(t.charAt(i), 0)+1);
        }

        int currIndex = 0; int prevIndex = 0;
        int ans = (int) 1e9;
        String minSubstring = "";
        while(currIndex<ssize){
            curr.put(s.charAt(currIndex), curr.getOrDefault(s.charAt(currIndex), 0)+1);
            // System.out.println("CurrIndex " + currIndex + " " + prevIndex);
            while(prevIndex<=currIndex && checkValid(curr, req)){
                // System.out.println("PrevIndex " + prevIndex);
                if(currIndex-prevIndex+1 < ans){
                    ans = currIndex-prevIndex+1;
                    minSubstring = s.substring(prevIndex, currIndex+1);
                }
                curr.put(s.charAt(prevIndex), curr.get(s.charAt(prevIndex))-1);
                prevIndex++;
            }
            // System.out.println("=========================");
            // for(Map.Entry<Character, Integer> entry: curr.entrySet()){
            //     System.out.println(entry.getKey() + " " + entry.getValue());
            // }
            // System.out.println("xxxxxxxxxxxxxxxxxxxxxx");
            // for(Map.Entry<Character, Integer> entry: req.entrySet()){
            //     System.out.println(entry.getKey() + " " + entry.getValue());
            // }
            // System.out.println(checkValid(curr, req));
            currIndex++;
        }

        return minSubstring;
    }
}
