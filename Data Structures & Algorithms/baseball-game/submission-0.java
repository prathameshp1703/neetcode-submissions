class Solution {
    public int calPoints(String[] operations) {
        int totalScore = 0;
        Stack<Integer> scores = new Stack<>();

        int size = operations.length;
        for(int i=0; i<size; i++){
            switch (operations[i]){
                case "+":
                    int prevScore1 = scores.pop();
                    int prevScore2 = scores.pop();
                    int newScore = prevScore1 + prevScore2;
                    scores.push(prevScore2);
                    scores.push(prevScore1);
                    scores.push(newScore);
                    break;
                case "C":
                    scores.pop();
                    break;
                case "D":
                    newScore = scores.peek()*2;
                    scores.push(newScore);
                    break;
                default:
                    scores.push(Integer.valueOf(operations[i]));
            }
        }

        while(scores.size()>0){
            totalScore += scores.pop();
        }

        return totalScore;
    }
}