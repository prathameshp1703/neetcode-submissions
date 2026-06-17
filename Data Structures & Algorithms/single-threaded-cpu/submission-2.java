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
            pq.offer(new Pair(tasks[i][0], tasks[i][1], i));
        }

        long curr = 0;
        Pair firstTask = pq.poll();
        curr = firstTask.first;
        ans[0] = (int) firstTask.index;
        curr+= firstTask.second;

        for(int i=1; i<size; i++){
            PriorityQueue<Pair> available = new PriorityQueue<>((a,b)->{
                if(a.second == b.second){
                    return Long.compare(a.index, b.index);
                }
                return Long.compare(a.second, b.second);
            });
            System.out.println(ans[i-1] + " " + pq.size());
            while(pq.size()>0 && pq.peek().first<=curr){
                available.add(pq.poll());
            }
            if(available.size() == 0){
                available.add(pq.poll());
            }
            
            ans[i] = (int) available.peek().index;
            curr  = Math.max(curr, available.peek().first);
            curr += available.peek().second;
            available.poll();
            while(available.size()>0){
                pq.add(available.poll());
            }
        }

        return ans;
    }
}