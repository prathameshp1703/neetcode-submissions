class Solution {
    private boolean isPal(String s){
        int start = 0; int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;end--;
        }
        return true;
    }

    private void solve(int index, String s, List<List<String>> ans, List<String> curr){
        if(index == s.length()){
            List<String> temp = new ArrayList<>(curr);
            ans.add(temp);
            return;
        }

        for(int i=index; i<s.length(); i++){
            String temp = s.substring(index, i+1);
            if(isPal(temp)){
                curr.add(temp);
                solve(i+1, s, ans, curr);
                curr.remove(temp);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        int index = 0;
        List<String> curr = new ArrayList<>();

        solve(index, s, ans, curr);

        return ans;
    }
}
