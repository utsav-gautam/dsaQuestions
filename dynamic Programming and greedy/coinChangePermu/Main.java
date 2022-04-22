import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int arr[]= new int [n];

        for(int i=0;i<n;i++)
            arr[i]=scn.nextInt();

        int amt=scn.nextInt();

        int totalPermu=coinChangePermu(arr,amt);
        System.out.println(totalPermu);
    }

    public static int coinChangePermu(int[] arr,int amt){
        int dp[]= new int[amt+1];
        dp[0]=1;

        for(int tar=1;tar<=amt;tar++){
            for(int i=0;i<arr.length;i++){
                if(arr[i]<=tar)
                dp[tar]+=dp[tar-arr[i]];
            }
        }

        return dp[amt];
    }
}