class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int numOfRescueBoats = 0;
        int start = 0; int end = people.length-1;

        while(start <= end){
            if(start == end){
                end--;
                numOfRescueBoats++;
            }
            else{
                if(people[start] + people[end] <= limit){
                    start++;
                    end--;
                    numOfRescueBoats++;
                }
                else{
                    end--;
                    numOfRescueBoats++;
                }
            }
        }

        return numOfRescueBoats;
    }
}