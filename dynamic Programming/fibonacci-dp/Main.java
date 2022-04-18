import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn= new Scanner(System.in);
    
    int n= scn.nextInt();
    
    long start=System.nanoTime();

    int fib=fibmemo(n, new int[n+1]);

    long end=System.nanoTime();
    System.out.println(end-start);
    System.out.println(fib);

    scn.close();
 }
 
 public static int fibmemo(int n, int[] ans){
     if(n==0||n==1){
        ans[n]=n;
        return ans[n];
     }
     
     if(ans[n]>0)
     return ans[n];
     
     int n1=fibmemo(n-1,ans);
     int n2=fibmemo(n-2,ans);
     
     ans[n]=n1+n2;
     return ans[n];
 }
 
 }