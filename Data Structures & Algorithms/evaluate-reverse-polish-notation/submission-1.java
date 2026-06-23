class Solution {

    private boolean isOperator(String token){
        if(token.length()>1) return false;
        if(token.charAt(0) == '+' || token.charAt(0) == '-' || 
        token.charAt(0) == '*' || token.charAt(0) == '/'){
            return true;
        }
        return false;
    }

    private Integer performOperation(int firstValue, int secondValue, String operator){
        switch (operator){
            case "+":
                return firstValue + secondValue;
            case "-":
                return firstValue - secondValue;
            case "*":
                return firstValue * secondValue;
            case "/":
                return firstValue / secondValue;
            default:
                return 0;
        }
    }

    public int evalRPN(String[] tokens) {
        int ans = 0;
        Stack<Integer> values = new Stack<>();
        int tokensSize = tokens.length;

        for(int i=0; i<tokensSize; i++){
            // System.out.println("val " + tokens[i]);
            if(isOperator(tokens[i])){
                int secondValue = values.pop();
                int firstValue = values.pop();
                // System.out.println(secondValue + " " + firstValue);
                values.push(performOperation(firstValue, secondValue, tokens[i]));
            }
            else{
                Integer num = Integer.valueOf(tokens[i]);
                // System.out.println("num " + num);
                values.push(num);
            }
        }

        ans = values.peek();
        return ans;
    }
}
