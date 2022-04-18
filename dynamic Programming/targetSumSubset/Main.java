import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        arr[i]=scn.nextInt();
        int tar=scn.nextInt();

        boolean result=tarSum(tar,arr);

        System.out.println(result);
    }

    public static boolean tarSum(int tar,int[] arr){
        boolean dp[][]= new boolean[arr.length+1][tar+1];
        for(int i=0;i<=arr.length;i++)
        dp[i][0]=true;

        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=tar;j++){
                if(arr[i-1]<=j)
                dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                else
                dp[i][j]=dp[i-1][j];
            }
        }

        return dp[arr.length][tar];

    }
}