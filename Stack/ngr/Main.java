import java.io.*;
import java.util.*;

public class Main{
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] ngr = solve(a);
 }

 public static int[] solve(int[] arr){
    int n=arr.length;
   int ngr[]=new int[n];
   Stack<Integer> st=new Stack<>();
   for(int i=n-1;i>=0;i--){
       while(st.size()>0&&st.peek()<arr[i]){
           st.pop();
       }
       if(st.size()==0)
       ngr[i]=-1;
       else
       ngr[i]=st.peek();
       
       st.push(arr[i]);
   }
   return ngr;
 }

}