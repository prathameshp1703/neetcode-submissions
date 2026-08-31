class WordDictionary {
    class Node{
        private int CHARS = 26;
        private Node[] nodes;
        private boolean isEnd;

        public Node(){
            nodes = new Node[CHARS];
            isEnd = false;
        }

        public boolean getEnd(){
            return isEnd;
        }

        public Node getNode(int index){
            return nodes[index];
        }

        public boolean containsKey(int index){
            return nodes[index] != null;
        }

        public void addKey(int index){
            nodes[index] = new Node();
        }

        public void setEnd(boolean isEnd){
            this.isEnd = isEnd;
        }
    }

    private Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        int size = word.length();

        for(int i=0; i<size; i++){
            int index = word.charAt(i)-'a';
            if(curr.containsKey(index)){
                curr = curr.getNode(index);
            }
            else{
                curr.addKey(index);
                curr = curr.getNode(index);
            }
        }
        curr.setEnd(true);
    }

    public boolean search(String word) {
        Node curr = root;
        int index = 0;
        return search(curr, word, index);
    }

    private boolean search(Node curr, String word, int index){
        int size = word.length();
        for(int i=index; i<size; i++){
            
            if(word.charAt(i) == '.'){
                // System.out.println("Hello " + i);
                boolean result = false;
                for(int j=0; j<26; j++){
                    if(curr.containsKey(j)){
                        
                        Node temp = curr.getNode(j);
                        result = result || search(temp, word, i+1);
                        // System.out.println(word + " " + j + " " + i + " " + result);
                    }
                }
                // System.out.println(word + " " + i + " " + result);
                // if(i == size-1){
                //     result = result || curr.getEnd();
                // }
                return result;
            }
            else{
                // System.out.println("Hi " + i);
                int searchCharIndex = word.charAt(i)-'a';
                if(!curr.containsKey(searchCharIndex)){
                    return false;
                }
                else{
                    curr = curr.getNode(searchCharIndex);
                }
            }
        }
        // System.out.println("Indexx " + index + " " + curr.getEnd());
        return curr.getEnd();
    }
}
