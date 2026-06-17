class Solution {
    class Pair{
        long first;
        long second;
        long index;

        Pair(long first, long second, long index){
            this.first = first;
            this.second = second;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.first == b.first){
                if(a.second == b.second){
                    return Long.compare(a.index, b.index);
                }
                return Long.compare(a.second, b.second);
            }
            return Long.compare(a.first, b.first);
        });

        int size = tasks.length;
        int[] ans = new int[size];

        for(int i=0; i<size; i++){
            pq.add(new Pair(tasks[i][0], tasks[i][1], i));
        }

        long curr = 0;
        Pair firstTask = pq.poll();
        curr = firstTask.first;
        ans[0] = (int) firstTask.index;
        curr+= firstTask.second;
        for(int i=1; i<size; i++){
            List<Pair> temp = new ArrayList<>();
            while(pq.size()>0 && pq.peek().first<=curr){
                temp.add(pq.poll());
            }
            if(temp.size() == 0){
                temp.add(pq.poll());
            }
            Collections.sort(temp, (a,b)->{
                if(a.second == b.second){
                    return Long.compare(a.index, b.index);
                }
                return Long.compare(a.second, b.second);
            });

            ans[i] = (int) temp.get(0).index;
            curr = Math.max(curr, temp.get(0).first);
            curr += temp.get(0).second;
            for(int j=1; j<temp.size(); j++){
                pq.add(temp.get(j));
            }
        }

        return ans;
    }
}