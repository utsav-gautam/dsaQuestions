import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        
        boolean ans=duplicateBrackets(str);
        System.out.println(ans);
    }
    
    public static boolean duplicateBrackets(String str){
        int i=0;
        Stack<Character> st=new Stack<>();
        while(i<str.length()){
            char ch=str.charAt(i);
            if(ch==')'){
                if(st.peek()=='(')
                    return true;
                while(st.size()>0&&st.peek()!='(')
                    st.pop();
                st.pop();
            }else
                st.push(ch);
                
                i++;
        }
        
        return false;
    }

}