	import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
	        Scanner scn=new Scanner(System.in);
	        
	        int n=scn.nextInt();
	        int val[]= new int[n];
	        int wt[]= new int[n];
	        
	        for(int i=0;i<n;i++)
	        val[i]=scn.nextInt();
	        
	        for(int i=0;i<n;i++)
	        wt[i]=scn.nextInt();
	        
	        int cap=scn.nextInt();
	        int max=unboundedKnapsack(n,val,wt,cap);
	        System.out.println(max);
	    }
	    
	    public static int unboundedKnapsack(int n,int[] val,int[] wt,int cap){
	        int dp[][]= new int[n+1][cap+1];
	        for(int i=1;i<=n;i++ ){
	            for(int j=1;j<=cap;j++){
	                if(j>=wt[i-1]){
	                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
	                }else{
	                    dp[i][j]=dp[i-1][j];
	                }
	            }
	        }
	        
	        return dp[n][cap];
	    }
	}