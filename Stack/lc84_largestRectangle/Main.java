class Solution {
    public static int[] nextSmallerToRight(int[] heights){
        int n=heights.length;
        int nsr[]= new int[n];
        Stack<Integer> st=new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(st.size()>0&&heights[st.peek()]>=heights[i])
                st.pop();
            
            if(st.size()==0)
                nsr[i]=n;
            else
                nsr[i]=st.peek();
            
            st.push(i);
        }
        
        return nsr;
    }
    public static int[] nextSmallerToLeft(int[] heights){
        int n=heights.length;
        int nsr[]= new int[n];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            while(st.size()>0&&heights[st.peek()]>=heights[i])
                st.pop();
            
            if(st.size()==0)
                nsr[i]=-1;
            else
                nsr[i]=st.peek();
            
            st.push(i);
        }
        
        return nsr;
    }
    
    public int largestRectangleArea(int[] heights) {
        int nsr[]= nextSmallerToRight(heights);
        int nsl[]= nextSmallerToLeft(heights);
        int max=0;
        for(int i=0;i<heights.length;i++)
            max=Math.max((nsr[i]-nsl[i]-1)*heights[i],max);
        return max;
    }
}