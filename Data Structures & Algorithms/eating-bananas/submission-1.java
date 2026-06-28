class Solution {

    int myCeil(int val, int div){
        if(val % div == 0){
            return (val/div);
        }
        return (val/div)+1;
    }

    private boolean isPossible(int mid, int[] piles, int h){
        int size = piles.length;
        int count = 0;
        for(int i=0; i<size; i++){
            count += myCeil(piles[i], mid);
            if(count > h) return false;
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int ans = -1;
        int left = 1; int right = Integer.MAX_VALUE-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(isPossible(mid, piles, h)){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return ans;
    }
}
