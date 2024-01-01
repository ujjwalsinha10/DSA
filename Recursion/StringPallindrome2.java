package Recursion;

public class StringPallindrome2 {

    public static void main(String[] args) {
        String str="ABCCKBA";
        boolean isPall=checkPallindrome(str);
        if(isPall){
            System.out.println("Pallindrome");
        }else{
            System.out.println("Not Pallindrome");
        }
    }

    private static boolean checkPallindrome(String str) {
        int left=0;
        int right= str.length()-1;
    
        while(left<right){
            char l=str.charAt(left);
            char r=str.charAt(right);
            if(!Character.isLetterOrDigit(l)){
                left++;
            }else if(!Character.isLetterOrDigit(r)){
                right--;
            }else if(Character.toLowerCase(l)!=Character.toLowerCase(r)) {
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
        
    }
    
}
