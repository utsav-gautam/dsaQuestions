import java.util.*;
public class Main {
	public static void main(String[] args) {
		int arr[]={1, 1, 2, 3, 4, 2, 1};
		
		int[] nextGreaterFreqArr=findNextGreaterFreqArr(arr);
		printArr(nextGreaterFreqArr);
	}
	
	public static void printArr(int[] arr){
		for(int el:arr){
			System.out.print(el+" ");
		}
	}
	
	public static int[] findNextGreaterFreqArr(int[]arr){
		HashMap<Integer,Integer> mp=new HashMap<>();
        //counting the occurences of the elements;
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i])){
                mp.replace(arr[i],mp.get(arr[i])+1);
            }else{
                mp.put(arr[i],1);
            }
        }
        
        int[] nextGreaterFreqArr=new int[arr.length];
        /* ------------------------------- using stack ------------------------------ */
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()>0){
                if(mp.get(st.peek())>mp.get(arr[i])){
                    nextGreaterFreqArr[i]=st.peek();
                    break;
                }
                else 
                    st.pop();
            }
            st.push(arr[i]);
            
            
            if(nextGreaterFreqArr[i]==0)
                nextGreaterFreqArr[i]=-1;
        }
        
        return nextGreaterFreqArr;

        /* ------------------------------- using loop ------------------------------- */
         for(int i=arr.length-1;i>=0;i--){
            for(int j=i+1;j<arr.length;j++){
                if(mp.get(arr[j])>mp.get(arr[i])){
                    nextGreaterFreqArr[i]=arr[j];
                    break;
                }
            }
            if(nextGreaterFreqArr[i]==0)
                nextGreaterFreqArr[i]=-1;
        }

	}
}
