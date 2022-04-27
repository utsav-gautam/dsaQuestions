import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);
        
        int n=scn.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        
        int dp[]= new int[n+1];
        dp[1]=arr[0];
        for( int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1],Math.max(dp[i-2]+arr[i-1],arr[i-1]));
        }
        
        System.out.print(dp[n]);
    }
}