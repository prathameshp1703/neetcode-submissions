class Solution {
    class Pair{
        private int first;
        private int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    private double myCeil(int val, int div){
        return (val*1.0)/div;
    }

    private boolean canBeMerged(Pair curr, Pair next, int target){
        double steps1 = myCeil(target-curr.first, curr.second);
        double steps2 = myCeil(target-next.first, next.second);

        if(steps1 >= steps2) return true;
        return false;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Pair> fleet = new PriorityQueue<>((a,b)->{
            if(a.first == b.first){
                return Integer.compare(a.second, b.second);
            }
            return Integer.compare(b.first, a.first);
        });

        int fleets = 0;
        int size = position.length;
        for(int i=0; i<size; i++){
            fleet.add(new Pair(position[i], speed[i]));
        }
        while(fleet.size()>0){
            Pair curr = fleet.poll();
            if(fleet.size()>0){
                Pair next = fleet.poll();
                
                if(canBeMerged(curr, next, target)){
                    // System.out.println(curr.first + " " + curr.second + " " +
                //  next.first + " " + next.second);
                    fleet.add(curr);
                }
                else{
                    // System.out.println(curr.first + " " + curr.second + " " +
                //  next.first + " " + next.second);
                    fleets++;
                    fleet.add(next);
                }
            }
            else{
                fleets++;
                continue;
            }
        }

        return fleets;
    }
}
