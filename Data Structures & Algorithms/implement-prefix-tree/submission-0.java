class PrefixTree {
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
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
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
        int size = word.length();

        for(int i=0; i<size; i++){
            int index = word.charAt(i)-'a';
            if(curr.containsKey(index)){
                curr = curr.getNode(index);
            }
            else{
                return false;
            }
        }
        if(curr.getEnd() == true){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        int size = prefix.length();

        for(int i=0; i<size; i++){
            int index = prefix.charAt(i)-'a';
            if(curr.containsKey(index)){
                curr = curr.getNode(index);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
