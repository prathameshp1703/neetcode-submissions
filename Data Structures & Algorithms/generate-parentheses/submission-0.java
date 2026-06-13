class Solution {

    private void solve(String curr, int openingBrackets, int closingBrackets, boolean takeOpening, int n, List<String> ans){
        if(curr.length() >= 2*n){
            ans.add(curr);
            return;
        }
        // System.out.println(openingBrackets + " " + closingBrackets + " " + takeOpening);
        if(openingBrackets<n && takeOpening == true){
            curr+= '(';
            openingBrackets++;
            solve(curr, openingBrackets, closingBrackets, true,  n, ans);
            solve(curr, openingBrackets, closingBrackets, false, n, ans);
        }
        if(closingBrackets<openingBrackets && takeOpening == false){
            curr+= ')';
            closingBrackets++;
            if(closingBrackets == n){
                solve(curr, openingBrackets, closingBrackets, true, n, ans);
            }
            else{
                solve(curr, openingBrackets, closingBrackets, true, n, ans);
                solve(curr, openingBrackets, closingBrackets, false, n, ans);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        String curr = "";
        List<String> ans = new ArrayList<>();
        int openingBrackets = 0;
        int closingBrackets = 0;
        solve(curr, openingBrackets, closingBrackets, true, n, ans);

        return ans;
    }
}
