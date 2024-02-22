package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: arr[] = {1,2,-4,-5}, N = 4
 * Output: 1 -4 2 -5

 */
public class RearrangeArrayElementsBySign {

    public static void main(String[] args) {
        int arr[]={1,2,-4,-5};
        int n=arr.length;
        int[] optimalResult = optimalApproach(arr,n);
        for(int i=0;i<optimalResult.length;i++){
            System.out.print(optimalResult[i]+" ");
        }
        System.out.println();
        int[] bruteForceResult = bruteForceApproach(arr,n);
        for(int i=0;i<bruteForceResult.length;i++){
            System.out.print(bruteForceResult[i]+" ");
        }

        System.out.println();
        System.out.println("Variety2");
        int arr2[]={1,2,-4,-5,3,4};
        int n2=arr2.length;
        System.out.print(variety2(arr2,n2));
    }

    private static List<Integer> variety2(int[] arr2, int n2) {
        List<Integer> pos= new ArrayList<>();
        List<Integer> neg= new ArrayList<>();
        List<Integer> result= new ArrayList<>();
        
        for(int i=0;i<n2;i++){
            if(arr2[i]>0){
                pos.add(arr2[i]);
            }else{
                neg.add(arr2[i]);
            }
        }
    
        if(pos.size()>neg.size()){
            for(int i=0;i<neg.size();i++){
                result.add(2*i,pos.get(i));
                result.add(2*i+1,neg.get(i));
            }
            int index = neg.size() * 2;
            for(int i=neg.size();i<pos.size();i++){
                result.add(index,pos.get(i));
                index++;
            }
        }else{
            for(int i=0;i<pos.size();i++){
                result.add(2*i,pos.get(i));
                result.add(2*i+1,neg.get(i));
            }
            int index = pos.size() * 2;
            for(int i=pos.size();i<neg.size();i++){
                result.add(index,neg.get(i));
                index++;
            }
        }
        return result;
    }

    private static int[] bruteForceApproach(int[] arr, int n) {
        int ans[]= new int[n];
        List<Integer> pos= new ArrayList<>();
        List<Integer> neg= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                pos.add(arr[i]);
            }else{
                neg.add(arr[i]);
            }
        }
        for(int i=0;i<n/2;i++){
            ans[2*i]=pos.get(i);
            ans[2*i+1]=neg.get(i);
        }
        return ans;
    }

    private static int[] optimalApproach(int[] arr, int n) {
        int ans[]= new int[n];
        int posIndex=0;
        int negIndex=1;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                ans[posIndex]=arr[i];
                posIndex+=2;
            }else{
                ans[negIndex]=arr[i];
                negIndex+=2;
            }
        }
        return ans;
    }
}