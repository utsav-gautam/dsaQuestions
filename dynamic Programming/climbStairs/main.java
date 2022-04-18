import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);

        int N=scn.nextInt();
        int[] dp=new int[N+1];
        dp[0]=1;
        for(int n=1;n<=N;n++){
            for(int i=1;i<=3&&n-i>=0;i++){
                dp[n]+=dp[n-i];
            }
        }

        System.out.println(dp[N]);
    }

    

}