class Solution {
    class Pair{
        Integer count;
        Character letter;

        Pair(Integer count, Character letter){
            this.count = count;
            this.letter = letter;
        }
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> lookup = new HashMap<>();
        int size = s.length();
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<size; i++){
            lookup.put(s.charAt(i), lookup.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(b.count, a.count);
        });
        for(Map.Entry<Character, Integer> entry : lookup.entrySet()){
            pq.add(new Pair(entry.getValue(), entry.getKey()));
        }
        while(pq.size()>1){

            Pair p1 = pq.poll();
            Pair p2 = pq.poll();


            p1.count--;
            p2.count--;

            ans.append(p1.letter);
            ans.append(p2.letter);
            if(p1.count>0){
                pq.add(p1);
            }
            if(p2.count>0){
                pq.add(p2);
            }
        }
        if(pq.size()>0){
            ans.append(pq.peek().letter);
        }
        
        if(ans.length() != s.length()){
            return "";
        }
        return ans.toString();
    }
}