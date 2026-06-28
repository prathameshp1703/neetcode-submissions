class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0; int right = rows-1;
        int ans = -1;
        while(left <= right){
            int mid = left+ (right-left)/2;
            if(target >= matrix[mid][0] && target<=matrix[mid][cols-1]){
                ans = mid;
                break;
            }
            else if(target > matrix[mid][cols-1]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        if(ans == -1){
            return false;
        }

        left = 0;right = cols-1;
        while(left <= right){
            int mid = left +(right-left)/2;
            if(target == matrix[ans][mid]){
                return true;
            }
            else if(target > matrix[ans][mid]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return false;
    }
}
