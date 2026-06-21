class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> currElements = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        int size = nums.length;
        for(int i=0; i<k; i++){
            while(currElements.size()>0 && currElements.peekLast()<nums[i]){
                currElements.removeLast();
            }
            currElements.add(nums[i]);
        }

        ans.add(currElements.peekFirst());
        for(int i=k; i<size; i++){
            if(currElements.peekFirst() == nums[i-k]){
                currElements.removeFirst();
            }
            while(currElements.size()>0 && currElements.peekLast()<nums[i]){
                currElements.removeLast();
            }
            currElements.add(nums[i]);
            ans.add(currElements.peekFirst());
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
