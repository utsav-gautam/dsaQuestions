import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int arr[][]= new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<=2;j++)
            arr[i][j]=scn.nextInt();
        }
        
        int dp[][]=new int[3][n+1];
        dp[0][1]=arr[0][0];
        dp[1][1]=arr[0][1];
        dp[2][1]=arr[0][2];
        
        for(int i=2;i<=n;i++){
            dp[0][i]=Math.min(dp[1][i-1],dp[2][i-1])+arr[i-1][0];
            dp[1][i]=Math.min(dp[0][i-1],dp[2][i-1])+arr[i-1][1];
            dp[2][i]=Math.min(dp[0][i-1],dp[1][i-1])+arr[i-1][2];
        }
        
        int ans=Math.min(Math.min(dp[0][n],dp[1][n]),dp[2][n]);
        System.out.println(ans);
    }
}