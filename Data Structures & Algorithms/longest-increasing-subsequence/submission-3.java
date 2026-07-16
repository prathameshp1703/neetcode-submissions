class Solution {
    private int lowerBound(int val, List<Integer> curr){
        int left = 0; int right = curr.size()-1;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(curr.get(mid) < val){
                ans = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        if(ans == -1) ans = 0;
        else ans+=1;
        return ans;
    }

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int index = 0;
        int ans = 0;
        List<Integer> curr = new ArrayList<>();
        for(int i=0; i<size; i++){
            if(curr.size() == 0){
                curr.add(nums[i]);
                continue;
            } 
            int lbound = lowerBound(nums[i], curr);
            // System.out.println(lbound);
            if(lbound == curr.size()){
                curr.add(nums[i]);
            }
            else{
                curr.set(lbound, nums[i]);
            }
            ans = Math.max(ans, curr.size());
        }
        ans = Math.max(ans, curr.size());
        return ans;
    }
}
