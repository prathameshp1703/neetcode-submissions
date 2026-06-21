class Solution {
    private boolean isSameDirection(int val1, int val2){
        if(val1 > 0 && val2 < 0){
            return false;
        }
        return true;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> curr = new Stack<>();
        int size = asteroids.length;
        for(int i=0; i<size; i++){
            curr.push(asteroids[i]);
            while(curr.size()>1){
                int secondElement = curr.pop();
                int firstElement = curr.pop();

                if(isSameDirection(firstElement, secondElement)){
                    curr.add(firstElement);
                    curr.add(secondElement);
                    break;
                }
                else{
                    if(Math.abs(firstElement) > Math.abs(secondElement)){
                        curr.add(firstElement);
                    }
                    else if(Math.abs(firstElement) < Math.abs(secondElement)){
                        curr.add(secondElement);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(curr.size()>0){
            ans.add(curr.pop());
        }
        Collections.reverse(ans);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}