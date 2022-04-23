import java.io.*;
import java.util.*;

/* -------------------------------------------------------------------------- */
/*                       tiling 2xn floor with 2x1 tiles                      */
/* -------------------------------------------------------------------------- */
public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int ans=tiling_tab(n);
    int ans=tiling_recur(n);
    System.out.println(dp[n]);

  }
/* -------------------------------- Recursive ------------------------------- */
  public static int tiling(int n) {
    if (n == 1)
      return 1;
      
    if(n==2)
        return 2;
        
    int count=tiling(n-1)+tiling(n-2);
    
    return count;
  }
/* ------------------------------- Tabulation ------------------------------- */
  public static int tiling_tab(int n){
      int dp[]= new int[n+1];
    dp[1]=1;
    dp[2]=2;
    for(int i=3;i<=n;i++)
    dp[i]=dp[i-1]+dp[i-2];

    return (dp[n]);
  }

  /* ------------------------ tiling MxN floor with Mx1 ----------------------- */
   public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        
        int ans=tiling(n,m);
        System.out.println(ans);
    }
    
    public static int tiling(int n,int m){
        if(n<m)
        return 1;
        if(n==m)
        return 2;
        
        int count=tiling(n-1,m)+tiling(n-m,m);
        
        return count;
    }
}