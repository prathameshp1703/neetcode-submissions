class Solution {
    public String decodeString(String s) {
        Stack<String> lookup = new Stack<>();
        int size = s.length();
        StringBuilder ans = new StringBuilder("");
        for(int i=0; i<size; i++){
            if(s.charAt(i) == ']'){
                StringBuilder sb = new StringBuilder("");
                while(lookup.size()>0 && !lookup.peek().equals("[")){
                    StringBuilder rb = new StringBuilder(lookup.pop());
                    rb.reverse();
                    sb.append(rb.toString());
                }
                // sb.reverse();
                lookup.pop();
                StringBuilder repeat = new StringBuilder("");
                while(lookup.size()>0 && (lookup.peek().length() == 1 &&
        lookup.peek().charAt(0) >= '0' &&
        lookup.peek().charAt(0) <= '9')){
                    repeat.append(lookup.pop() + "");
                }
                repeat.reverse();
                StringBuilder repeatedString = new StringBuilder();
                for(int j=0; j<Integer.valueOf(repeat.toString()); j++){
                    repeatedString.append(sb);
                }
                repeatedString.reverse();
                lookup.push(repeatedString.toString());
            }
            else{
                lookup.push(s.charAt(i) + "");
            }
        }
        while(lookup.size()>0){
            ans.insert(0, lookup.pop());
        }
        return ans.toString();
    }
}