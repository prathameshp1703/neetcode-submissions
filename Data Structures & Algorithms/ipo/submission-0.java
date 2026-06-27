class Solution {
    class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int ans = 0;
        PriorityQueue<Pair> projectInfo = new PriorityQueue<>((a,b)->{
            if(a.first == b.first){
                return Integer.compare(b.second, a.second);
            }
            return Integer.compare(a.first, b.first);
        });

        int projectsSize = profits.length;

        for(int i=0; i<projectsSize; i++){
            projectInfo.add(new Pair(capital[i], profits[i]));
        }
        PriorityQueue<Integer> available = new PriorityQueue<>((a,b)->{
            return Integer.compare(b, a);
        });

        while(projectInfo.size()>0 && projectInfo.peek().first <= w){
            available.add(projectInfo.poll().second);
        }

        while(k>0){
            if(available.size() == 0){
                break;
            }
            w += available.poll();
            while(projectInfo.size()>0 && projectInfo.peek().first <= w){
                available.add(projectInfo.poll().second);
            }
            k--;
        }

        return w;
    }
}