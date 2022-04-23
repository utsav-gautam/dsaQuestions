import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);

        String str=scn.nextLine();

        Main obj= new Main();
        int ans=obj.findSubsequence(0,0,0,0,"",str.length(),str);

        System.out.println(ans);

    }
/* -------------------------------- Recursive ------------------------------- */
    int findSubsequence(int aCount,int bCount,int cCount,int idx,String sub,int n,String str){
        if(idx==n){
            if(aCount>0&&bCount>0&&cCount>0)
            return 1;
            else 
            return 0;
        }

        int count=0;

        if(sub==""){
            if(str.charAt(idx)=='a'){
               count= findSubsequence(aCount+1,bCount,cCount,idx+1,sub+'a',n,str)+
                      findSubsequence(aCount,bCount,cCount,idx+1,sub,n,str);
            }else{
                count=findSubsequence(aCount,bCount,cCount,idx+1,sub,n,str);
            }
        }else if(sub.charAt(sub.length()-1)=='a'){
            if(str.charAt(idx)=='a'){
               count= findSubsequence(aCount+1,bCount,cCount,idx+1,sub+'a',n,str)+
                      findSubsequence(aCount,bCount,cCount,idx+1,sub,n,str);
            }else if(str.charAt(idx)=='b'){
               count= findSubsequence(aCount+1,bCount+1,cCount,idx+1,sub+'b',n,str)+
                      findSubsequence(aCount,bCount,cCount,idx+1,sub,n,str);
            }else{
                count=findSubsequence(aCount,bCount,cCount,idx+1,sub,n,str);
            }
        }else if(sub.charAt(sub.length()-1)=='b'){
            if(str.charAt(idx)=='b'){
               count= findSubsequence(aCount+1,bCount+1,cCount,idx+1,sub+'b',n,str)+
                      findSubsequence(aCount,bCount,cCount,idx+1,sub,n,str);
            }else if(str.charAt(idx)=='c'){
               count= findSubsequence(aCount+1,bCount,cCount+1,idx+1,sub+'c',n,str)+
                      findSubsequence(aCount,bCount,cCount,idx+1,sub,n,str);
            }else{
                count=findSubsequence(aCount,bCount,cCount,idx+1,sub,n,str);
            }
        }else{
            if(str.charAt(idx)=='c'){
               count= findSubsequence(aCount+1,bCount,cCount+1,idx+1,sub+'c',n,str)+
                      findSubsequence(aCount,bCount,cCount,idx+1,sub,n,str);
            }else{
                count=findSubsequence(aCount,bCount,cCount,idx+1,sub,n,str);
            }
        }

        return count;
    }


    /* ------------------------------- Tabulation ------------------------------- */
     public static int findSubsequence(String str){
        int aCount=0;
        int bCount=0;
        int cCount=0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'){
                aCount=1+2*aCount;  
            }else if(str.charAt(i)=='b'){
                bCount=aCount+2*bCount;
            }else{
                cCount=bCount+2*cCount;
            }
        }

        return cCount;

    }
}