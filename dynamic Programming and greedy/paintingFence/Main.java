import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner Scn= new Scanner(System.in);
        int n=scn.nextInt();
        int k=scn.nextInt();
        
        int dp[]= new int[n+1];
        
        int diff=k;
        int same=0;
        dp[1]=k;
        for(int i=2;i<=n;i++){
            same=diff;
            diff=dp[i-1]*(k-1);
            dp[i]=same+diff;
        }
        
        System.out.pritln(dp[n]);
    }
}