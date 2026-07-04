/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    private int bSearch(int left, int right, int target, MountainArray mountainArr, 
        boolean isReverse){
        int ans = -1;
        while(left <= right){
            int mid = left +(right-left)/2;
            if(mountainArr.get(mid) == target){
                ans = mid;
                right = mid-1;
            }
            else if(mountainArr.get(mid) > target){
                if(isReverse == true){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            else{
                if(isReverse == true){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
        }
        return ans;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        int left = 0;
        int right = size-1;

        int peek = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int leftMax = (int) -1e9;
            int rightMax = (int) - 1e9;
            if(mid-1>=0){
                leftMax = mountainArr.get(mid-1);
            }
            if(mid+1 < size){
                rightMax = mountainArr.get(mid+1);
            }
            if(mountainArr.get(mid)>=leftMax && mountainArr.get(mid)>=rightMax){
                peek = mid;
                break;
            }
            else if(mountainArr.get(mid)>leftMax){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        int leftSearch = bSearch(0, peek-1, target, mountainArr, false);
        int rightSearch = bSearch(peek+1, size-1, target, mountainArr, true);

        int mid = -1;
        if(mountainArr.get(peek) == target) mid = peek;

        int ans = -1;
        if(leftSearch != -1){
            ans = leftSearch;
        }
        else if(mid != -1){
            ans = mid;
        }
        else if(rightSearch != -1){
            ans = rightSearch;
        }
        return ans;
    }
}