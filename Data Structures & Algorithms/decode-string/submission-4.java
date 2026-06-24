class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> decodedString = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int num = 0;

        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
            }
            else if(ch == ']'){
                StringBuilder prev = decodedString.pop();
                int repeat = nums.pop();

                for(int i=0; i<repeat; i++){
                    prev.append(curr);
                }
                curr = prev;
            }
            else if(ch == '['){
                nums.push(num);
                num = 0;
                decodedString.push(curr);
                curr = new StringBuilder();
            }
            else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}