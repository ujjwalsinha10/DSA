package Search.BSon2DArray;
/*
 * Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
 * Output: [1,1]
 */
public class PeakElement {
    public static void main(String[] args) {
        int [][]mat =  {{ 9, 8 }, { 2, 6 } };//{{10,20,15},{21,30,14},{7,16,32}};
        int col=2;
        int row=2;
        int[] result = findPeak(mat,row,col);
        System.out.println("Index:"+result[0]+","+result[1]);
    }

    private static int[] findPeak(int[][] mat, int row, int col) {
        int n=mat.length;
        int m=mat[0].length;

        int start=0;
        int end=m-1;
        while(start<=end){
            int mid=(start+end)/2;
            int rowNum=getMaxElement(mat,mid);

            int left=-1;
            int right=-1;
            if(mid-1>=0){
                left=mat[rowNum][mid-1];
            }
            if(mid+1<m){
                right=mat[rowNum][mid+1];
            }

            if(mat[rowNum][mid]>right && mat[rowNum][mid]>left){
                return new int[]{row,mid};
            }else if(mat[rowNum][mid]>right){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    private static int getMaxElement(int[][] mat, int mid) {
        int index=-1;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<mat.length;i++){
            int elm=mat[i][mid];

            if(elm>maxi){
                maxi=Math.max(maxi, elm);
                index=i;
            }
        }
        return index;
    }
}
