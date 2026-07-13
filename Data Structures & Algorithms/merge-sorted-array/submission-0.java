class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = nums1.length-1;
        int ptrNums1 = m-1;
        int ptrNums2 = n-1;
        while(size>=0 && ptrNums1>=0 && ptrNums2>=0){
            if(nums1[ptrNums1] >= nums2[ptrNums2]){
                nums1[size] = nums1[ptrNums1];
                size--; ptrNums1--;
            }
            else{
                nums1[size] = nums2[ptrNums2];
                size--; ptrNums2--;
            }
        }

        while(ptrNums2>=0 && size>=0){
            nums1[size] = nums2[ptrNums2];
            size--; ptrNums2--;
        }
    }
}