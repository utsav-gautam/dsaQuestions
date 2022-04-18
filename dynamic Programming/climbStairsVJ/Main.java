import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);
        int N=scn.nextInt();
        int arr[]= new int[N];
        for(int i=0;i<N;i++)
        arr[i]=scn.nextInt();
        int dp[]= new int[N+1];
        dp[N]=1;


        // int result=climbStairs(0,N,arr,dp);
        int result=climbStairs_tab(arr);
        System.out.println(result);
    }
    public static int climbStairs_tab(int[] arr){
        int[] dp=new int[arr.length+1];

        dp[arr.length]=1;

        for(int i=arr.length-1;i>=0;i--){
            int count=0;
            for(int jumps=1;jumps<=arr[i]&&jumps+i<=arr.length;jumps++){
                count+=dp[i+jumps];
            }
            dp[i]=count;
        }

        return dp[0];
        
    }

    public static int climbStairs(int src,int dest,int[] arr,int dp[]){
        if(src==dest)
        return 1;

        if(dp[src]!=0)
        return dp[src];

        int count=0;
        for(int jumps=1;jumps<=arr[src]&&jumps+src<=dest;jumps++){
            count+=climbStairs(src+jumps,dest,arr,dp);
        }

        return dp[src]=count;
    }
}
