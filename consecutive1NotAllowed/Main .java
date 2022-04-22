class Solution {
    long countStrings(int n) {
        long dp[][]=new long[2][n];
        dp[0][0]=1;
        dp[1][0]=1;
        for(int col=1;col<n;col++){
            dp[0][col]=(dp[0][col-1]+dp[1][col-1])%1000000007;
            dp[1][col]=(dp[0][col-1])%1000000007;
        }
        
        return (dp[0][n-1]+dp[1][n-1])%1000000007;
    }
    
    
}