/* ------------------------------- Memoization ------------------------------ */
class Solution {
    public int rob(int[] nums) {
        int dp[]= new int[nums.length+1];
        dp[1]=nums[0];
        for(int i=2;i<=nums.length;i++)
            dp[i]=-1;
        int max=robHouse(nums.length,nums,dp);
        return max;
    }
    
    public static int robHouse(int n,int[] nums,int[] dp){
        if(n<=1)
            return dp[n];
        
        if(dp[n]>=0)
            return dp[n];
        
        dp[n]=Math.max(robHouse(n-1,nums,dp),nums[n-1]+robHouse(n-2,nums,dp));
        return dp[n];
    }
}

/* ------------------------------- Tabulation ------------------------------- */
class Solution {
    public int rob(int[] nums) {
        int dp[]= new int[nums.length+1];
        dp[1]=nums[0];
        for(int i=2;i<=nums.length;i++)
            dp[i]=Math.max(dp[i-1],nums[i-1]+dp[i-2]);
        
        return dp[nums.length];
    }
}
