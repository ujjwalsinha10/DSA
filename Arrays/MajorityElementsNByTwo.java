package Arrays;

/*
 * Input Format:  N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}
 * Result: 4
 */
public class MajorityElementsNByTwo {
    public static void main(String[] args) {
        int nums[]={4,4,2,4,3,4,4,3,2,4};
        System.out.println("Majority element is: "+MooresVotingAlgo(nums));
    }

    private static int MooresVotingAlgo(int[] nums) {
        int element=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                count=1;
                element=nums[i];
            }else{
                if(nums[i]==element){
                    count++;
                }else{
                    count--;
                }
            }
        }

        int count1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==element){
                count1++;
            }
        }

        if(count1>nums.length/2){
            return element;
        }else{
            return -1;
        }
    }
}
