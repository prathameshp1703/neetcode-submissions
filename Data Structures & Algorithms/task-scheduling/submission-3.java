class Solution {
    class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        int tasksSize = tasks.length;

        for(int i=0; i<tasksSize; i++){
            freq.put(tasks[i]-'A', freq.getOrDefault(tasks[i]-'A', 0)+1);
        }
        int currTime = 0;
        PriorityQueue<Pair> intervals = new PriorityQueue<>((a, b)->{
            if(a.first == b.first){
                return Integer.compare(a.second, b.second);
            }
            return Integer.compare(b.first, a.first);
        });

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            intervals.add(new Pair(entry.getValue(), 1));
        }
        PriorityQueue<Pair> cooldown = new PriorityQueue<>((a, b)->{
            if(a.first == b.first){
                return Integer.compare(b.second, a.second);
            }
            return Integer.compare(a.first, b.first);
        });
        while(intervals.size()>0 || cooldown.size()>0){
            currTime++;
            while(cooldown.size()>0 && cooldown.peek().first <= currTime){
                intervals.add(new Pair(cooldown.peek().second, cooldown.peek().first));
                cooldown.poll();
            }
            if(intervals.size()>0){
                Pair curr = intervals.poll();
                // System.out.println(curr.first + " " + curr.second);
                curr.first --;
                if(curr.first > 0){
                    cooldown.add(new Pair(currTime+n+1, curr.first));
                }
            }
        }
        return currTime;
    }
}
