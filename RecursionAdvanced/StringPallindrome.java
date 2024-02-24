package RecursionAdvanced;

public class StringPallindrome {
    public static void main(String[] args) {
        String s="madsm";
        System.out.println(checkPallindrome(0,s));
    }

    private static boolean checkPallindrome(int i, String s) {
        if(i>=s.length()/2) return true;
        if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        return checkPallindrome(i+1, s);
    }
}
