class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<Integer> tripInfo = new ArrayList<>(Collections.nCopies(1001, 0));
        int tripsSize = trips.length;

        for(int i=0; i<tripsSize; i++){
            int startIndex = trips[i][1];
            int endIndex = trips[i][2];

            tripInfo.set(startIndex, tripInfo.get(startIndex)+trips[i][0]);
            tripInfo.set(endIndex, tripInfo.get(endIndex)-trips[i][0]);
        }

        int curr = 0;
        int tripInfoSize = tripInfo.size();
        for(int i=0; i<tripInfoSize; i++){
            curr+= tripInfo.get(i);
            // System.out.println(tripInfo.get(i) + " " + curr);
            if(curr > capacity){
                return false;
            }
        }
        return true;
    }
}