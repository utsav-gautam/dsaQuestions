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

}