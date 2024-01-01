package Recursion;

public class StringPallindrome {

    public static void main(String[] args) {
        String str="ABCCKBA";
        checkPallindrome(str);
        if(isPall){
            System.out.println("Pallindrome");
        }else{
            System.out.println("Not Pallindrome");
        }
    }

    static boolean isPall=false;
    private static void checkPallindrome(String str) {
        char [] c= new char[str.length()];
        for(int i=0;i<str.length();i++){
            c[i]=str.charAt(i);
        }
        int start=0;
        int end=str.length()-1;
        
        while(start<=end){
            if(c[start]==c[end]){
                start ++;
                end --;
                isPall=true;
            }else{
                isPall=false;
                return;
            }
        }
        
    }
    
}
