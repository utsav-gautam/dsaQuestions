import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();

        int val[]= new int[n];
        int wt[]= new int[n];

        for(int i=0;i<n;i++)
        val[i]=scn.nextInt();

        for(int i=0;i<n;i++)
        wt[i]=scn.nextInt();

        int cap=scn.nextInt();
        int profit=maxProfit(val,wt,cap);
        System.out.println(profit);

    }

    public static int maxProfit(int val[],int wt[],int maxCap){

        int dp[][]= new int[val.length+1][maxCap+1];

        for(int ele=1;ele<=val.length;ele++){
            for(int cap=1;cap<=maxCap;cap++){
                if(wt[ele-1]<=cap)
                    dp[ele][cap]=Math.max(val[ele-1]+dp[ele-1][cap-wt[ele-1]],dp[ele-1][cap]);
                else
                    dp[ele][cap]=dp[ele-1][cap];
            }
        }

        return dp[val.length][maxCap];
    }
}