class Solution {
    class Pair{
        int temp;
        int index;

        Pair(int temp, int index){
            this.temp = temp;
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int size = temperatures.length;

        List<Integer> ans = new ArrayList<>();
        for(int i=size-1; i>=0; i--){
            while(stack.size()>0 && stack.peek().temp <= temperatures[i]){
                stack.pop();
            }

            if(stack.size()>0){
                ans.add(stack.peek().index-i);
            }
            else{
                ans.add(0);
            }
            stack.push(new Pair(temperatures[i], i));
        }

        Collections.reverse(ans);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
