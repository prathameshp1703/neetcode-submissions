class Solution {

    class Pair{
        int height;
        int index;

        Pair(int height, int index){
            this.height = height;
            this.index = index;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Pair> curr = new Stack<>();
        int heightSize = heights.length;

        int ans = 0;
        for(int i=0; i<heightSize; i++){
            while(curr.size()>0 && curr.peek().height >= heights[i]){
                Pair temp = curr.pop();
                int leftSize = 1; int rightSize = 1;
                if(curr.size()>0){
                    leftSize = temp.index-curr.peek().index;
                }
                else{
                    leftSize = temp.index+1;
                }
                rightSize = i-temp.index;
                int width = leftSize + rightSize -1;
                ans = Math.max(ans, width * temp.height);
            }

            curr.push(new Pair(heights[i], i));
        }

        while(curr.size()>0){
            int leftSize = 1; int rightSize = (heightSize-curr.peek().index);
            Pair temp = curr.pop();
            if(curr.size()>0){
                leftSize = temp.index-curr.peek().index;
            }
            else{
                leftSize = temp.index+1;
            }
            int width = leftSize + rightSize -1;
            ans = Math.max(ans, width * temp.height);
        }

        return ans;
    }
}
