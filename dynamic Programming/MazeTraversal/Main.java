import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();

        int dp[][]= new int[n][m];
        int arr[][]= new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                arr[i][j]=scn.nextInt();


       int ans= minCost(n-1,m-1,arr,dp);
       System.out.println(ans);

       scn.close();
    }

    public static int minCost(int row,int col,int[][]cost,int dp[][]){

        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                if(i==0&&j==0)
                dp[i][j]=cost[i][j];
                else if(i==0)
                dp[i][j]=dp[i][j-1]+cost[i][j];
                else if(j==0)
                dp[i][j]=dp[i-1][j]+cost[i][j];
                else
                dp[i][j]=cost[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[row][col];
    }

}