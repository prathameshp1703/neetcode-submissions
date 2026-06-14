class Solution {

    private void solve(StringBuilder curr, int openingBrackets, int closingBrackets, boolean takeOpening, int n, List<String> ans){
        if(curr.length() >= 2*n){
            ans.add(curr.toString());
            return;
        }

        if(openingBrackets<n && takeOpening){
            curr.append('(');
            openingBrackets++;
            solve(curr, openingBrackets, closingBrackets, true,  n, ans);
            solve(curr, openingBrackets, closingBrackets, false, n, ans);
            curr.setLength(curr.length()-1);
        }
        if(closingBrackets<openingBrackets && !takeOpening){
            curr.append(')');
            closingBrackets++;
            if(closingBrackets == n){
                solve(curr, openingBrackets, closingBrackets, true, n, ans);
            }
            else{
                solve(curr, openingBrackets, closingBrackets, true, n, ans);
                solve(curr, openingBrackets, closingBrackets, false, n, ans);
            }
            curr.setLength(curr.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder curr = new StringBuilder("");
        List<String> ans = new ArrayList<>();
        int openingBrackets = 0;
        int closingBrackets = 0;
        solve(curr, openingBrackets, closingBrackets, true, n, ans);

        return ans;
    }
}
