package Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int A[][] = { { 1, 1, 1, 1 }, 
                      { 2, 2, 2, 2 }, 
                      { 3, 3, 3, 3 }, 
                      { 4, 4, 4, 4 } }; 

        int[][] firstApproach = firstApproach(A);
        for (int i = 0; i < firstApproach.length; i++){
            // Loop through all elements of current row
            for (int j = 0; j < firstApproach[i].length; j++)
                System.out.print(firstApproach[i][j] + " ");
            System.out.println("\n");
        }

        System.out.println();
        
        int[][] secondApproach = secondApproach(A);
        for (int i = 0; i < secondApproach.length; i++){
            // Loop through all elements of current row
            for (int j = 0; j < secondApproach[i].length; j++)
                System.out.print(secondApproach[i][j] + " ");
            System.out.println("\n");
        }
    }

    private static int[][] secondApproach(int[][] a) {
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a[0].length;j++){
                int temp=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=temp;
            }
        }
        return a;
    }

    private static int[][] firstApproach(int[][] a) {
        int [][]b=new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                b[i][j]=a[j][i];
            }
        }
        return b;
    }
}
