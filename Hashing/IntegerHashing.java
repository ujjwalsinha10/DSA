package Hashing;

public class IntegerHashing {
    public static void main(String[] args) {
        int arr[]= {1,3,2,1,3};

        //precompute
        int hash[]= new int[13];
        for(int i=0;i<arr.length;i++){
            hash[arr[i]] +=1;
        }

        int q=1;
        System.out.println(hash[q]);
        
    }
    
}
