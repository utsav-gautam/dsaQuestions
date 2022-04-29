import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> opd= new Stack<>();
    Stack<Character> opr= new Stack<>();

    for(int i=0;i<exp.length();i++){
        if(exp.charAt(i)=='('){
            opr.push(exp.charAt(i));
        }else if(exp.charAt(i)==')'){
            while(opr.peek()!='('){
                int v2=opd.pop();
                int v1=opd.pop();
                opd.push(operation(v1,v2,opr.pop()));
            }
            opr.pop();
        } else if(Character.isDigit(exp.charAt(i))){
            opd.push(exp.charAt(i)-'0');
        }else if(exp.charAt(i)=='+'||exp.charAt(i)=='-'||exp.charAt(i)=='*'||exp.charAt(i)=='/'){
                while(opr.size()>0&&opr.peek()!='('&&precedence(exp.charAt(i))<=precedence(opr.peek())){
                    int v2=opd.pop();
                    int v1=opd.pop();
                    opd.push(operation(v1,v2,opr.pop()));
                }
                opr.push(exp.charAt(i));
            }
        }
        while(opr.size()!=0){
                int v2=opd.pop();
                int v1=opd.pop();
                opd.push(operation(v1,v2,opr.pop()));
            }
        System.out.println(opd.peek());
    }

 public static int precedence(char opr){
     if(opr=='+'){
         return 1;
     }else if(opr=='-'){
         return 1;
     }else if(opr=='*'){
         return 2;
     }else 
        return 2;
 }
 public static int operation(int v1,int v2,char opr){
     if(opr=='+'){
         return v1+v2;
     }else if(opr=='-'){
         return v1-v2;
     }else if(opr=='*'){
         return v1*v2;
     }else 
        return v1/v2;
 }
}