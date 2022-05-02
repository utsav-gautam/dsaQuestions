import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then
        // print "none"

        int i=0;
        int j=0;

        while(i<arr.length&&j<arr.length){
            if(i==j)
            j++;
            else if(arr[i][j]==0&&arr[j][i]==1){
                j++;
            }else{
                i++;
                j=0;
            }
        }

        if(i>=arr.length){
            System.out.println("none");
        }else{
            System.out.println(i);
        }
    }


    /* -------------------------- using stack----------------------- */

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then print "none"
        Stack < Integer > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        while(st.size()>1){
            int v1=st.pop();
            int v2=st.pop();

            if(arr[v1][v2]==1)
                st.push(v2);
            else
                st.push(v1);
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i][st.peek()]==0&&i!=st.peek()){
                System.out.println("none");
                return;
            }
        }

        System.out.println(st.peek());
    }
}