class Solution {
    public class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> closestElements = new PriorityQueue<>((a, b)->{
            if(a.first == b.first){
                return Integer.compare(b.second, a.second);
            }
            return Integer.compare(b.first, a.first);
        });

        int arraySize = arr.length;
        for(int i=0; i<arraySize; i++){
            int diff = Math.abs(x-arr[i]);
            if(closestElements.size()<k){
                closestElements.add(new Pair(diff, arr[i]));
            }
            else{
                if(diff < closestElements.peek().first){
                    closestElements.poll();
                    closestElements.add(new Pair(diff, arr[i]));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(closestElements.size()>0){
            Pair element = closestElements.poll();
            ans.add(element.second);
        }

        Collections.sort(ans);

        return ans;
    }
}