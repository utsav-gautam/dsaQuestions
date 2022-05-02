class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->{
           return a[0]-b[0]; 
        });
        
        ArrayList<int[]> comb_intr=new ArrayList<>();
        
        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i][1]>=intervals[i+1][0]){
                intervals[i+1][0]=Math.min(intervals[i][0],intervals[i+1][0]);
                intervals[i+1][1]=Math.max(intervals[i][1],intervals[i+1][1]);
            }else{
                comb_intr.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        comb_intr.add(new int[]{intervals[n-1][0],intervals[n-1][1]});
        
          
        
        return comb_intr.toArray(new int[comb_intr.size()][]);
        
    }
}