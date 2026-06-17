class Solution {
    class Pair{
        int count;
        char letter;

        Pair(int count, char letter){
            this.count = count;
            this.letter = letter;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((firstPair, secondPair)->{
            if(firstPair.count == secondPair.count){
                return Integer.compare(firstPair.letter - 'a', secondPair.letter - 'a');
            }
            return Integer.compare(secondPair.count, firstPair.count);
        });

        pq.add(new Pair(a, 'a'));
        pq.add(new Pair(b, 'b'));
        pq.add(new Pair(c, 'c'));

        StringBuilder sb = new StringBuilder("");
        while(pq.size()>0){
            Pair firstPair = pq.poll();
            if(firstPair.count == 0) continue;
            if(sb.length() <= 1){
                sb.append(firstPair.letter);
                firstPair.count--;
                if(firstPair.count > 0){
                    pq.add(firstPair);
                }
            }
            else{
                int currLength = sb.length();
                if(firstPair.letter == sb.charAt(currLength-1) &&
                    firstPair.letter == sb.charAt(currLength-2)){
                    if(pq.size()>0){
                        Pair secondPair = pq.poll();
                        if(secondPair.count == 0){
                            continue;
                        }
                        sb.append(secondPair.letter);
                        secondPair.count--;
                        if(secondPair.count>0){
                            pq.add(secondPair);
                        }
                        
                    }
                    else{
                        return sb.toString();
                    }
                }
                else{
                    sb.append(firstPair.letter);
                    firstPair.count--;
                    
                }
                if(firstPair.count > 0){
                    pq.add(firstPair);
                }
            }
        }

        return sb.toString();
    }
}